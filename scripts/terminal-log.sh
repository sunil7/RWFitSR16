#!/usr/bin/env bash
set -euo pipefail

workspace_root="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")/.." && pwd)"
transcript="$(mktemp "${TMPDIR:-/tmp}/rwfit-terminal.XXXXXX")"
offset="${transcript}.offset"
finished="${transcript}.finished"
trap 'rm -f -- "$transcript" "$offset" "$finished"' EXIT

command -v script >/dev/null || {
  printf '%s\n' "The 'script' utility is required for terminal logging." >&2
  exit 1
}

command -v python3 >/dev/null || {
  printf '%s\n' "Python 3 is required for terminal logging." >&2
  exit 1
}

printf -v shell_command '%q ' bash -i
(
  if script --quiet --flush --log-out "${transcript}" --command "${shell_command}"; then
    status=0
  else
    status=$?
  fi
  printf '%s' "$status" > "$finished"
  exit "$status"
) &
terminal_pid=$!

while [[ ! -f "$finished" ]]; do
  python3 "${workspace_root}/scripts/sync-terminal-log.py" \
    "${transcript}" "${offset}" "${workspace_root}/TERMINAL_COMMANDS_RESULTS.md"
  sleep 0.2
done

if wait "$terminal_pid"; then
  status=0
else
  status=$?
fi
python3 "${workspace_root}/scripts/sync-terminal-log.py" \
  "${transcript}" "${offset}" "${workspace_root}/TERMINAL_COMMANDS_RESULTS.md"
exit "$status"
