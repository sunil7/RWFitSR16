#!/usr/bin/env python3
import datetime
import html
import re
import sys
from pathlib import Path


def strip_terminal_controls(text: str) -> str:
    text = re.sub(r"\x1b\][^\x07]*(?:\x07|\x1b\\)", "", text)
    text = re.sub(r"\x1b\[[0-?]*[ -/]*[@-~]", "", text)
    text = re.sub(r"\x1b[@-_]", "", text)
    return text.replace("\r\n", "\n").replace("\r", "\n").replace("\x08", "")


def main() -> None:
    if len(sys.argv) != 4:
        raise SystemExit("usage: sync-terminal-log.py TRANSCRIPT OFFSET MARKDOWN")

    transcript_path, offset_path, markdown_path = map(Path, sys.argv[1:])
    previous_offset = int(offset_path.read_text() or "0") if offset_path.exists() else 0
    transcript_size = transcript_path.stat().st_size
    if previous_offset > transcript_size:
        raise RuntimeError("terminal transcript became shorter than its saved offset")

    with transcript_path.open("rb") as transcript:
        transcript.seek(previous_offset)
        chunk = transcript.read().decode("utf-8", errors="replace")

    visible_text = strip_terminal_controls(chunk)
    if not visible_text:
        offset_path.write_text(str(transcript_size))
        return

    timestamp = datetime.datetime.now(datetime.timezone.utc).strftime("%Y-%m-%d %H:%M:%S UTC")
    entry = (
        f"\n<details>\n<summary>Terminal transcript - {timestamp}</summary>\n\n"
        f"<pre>{html.escape(visible_text)}</pre>\n</details>\n"
    )
    with markdown_path.open("a", encoding="utf-8") as markdown:
        markdown.write(entry)
    offset_path.write_text(str(transcript_size))


if __name__ == "__main__":
    main()
