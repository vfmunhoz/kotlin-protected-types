package io.github.vfmunhoz.protectedtypes.extensions

fun String.replaceFrom(start: Int, end: Int, replacement: CharSequence, ignores: Set<Char> = emptySet()): String {
    if(start > end) throw throw IndexOutOfBoundsException("End index ($end) is less than start index ($start).")

    val builder = StringBuilder()

    builder.appendRange(this, 0, start)
    for(pos in start.. end) {
        if(ignores.contains(this[pos])) {
            builder.append(this[pos])
            continue
        }

        builder.append(replacement)
    }
    builder.appendRange(this, end + 1, this.length)

    return builder.toString()
}
