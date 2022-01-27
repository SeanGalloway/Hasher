package odu


fun main(args: Array<String>) {

    if (args.size != 3){
        throw IllegalArgumentException("Must provide 3 arguments")
    }

    val inputFormat = args[0]
    val initialChar = if (inputFormat == "ascii") args[1][0].code.toUByte() else parseHexInput(args[1])[0]
    val word = if (inputFormat == "ascii") args[2].toByteArray().toUByteArray() else parseHexInput(args[2])

    println(hash(initialChar, word).toUByte(2).toString(16).padStart(2,'0'))
}

fun parseHexInput(hex: String): UByteArray {
    val array = arrayListOf<UByte>()
    for (index in (0..(hex.length-2)).step(2)) {
        array.add(hex.slice(index..(index+1)).toUByte(16))
    }
    return array.toUByteArray()
}

fun hash(initialCharacter: UByte, word: UByteArray): String {
    var hash = initialCharacter.toString(2).padStart(8, '0')
    word.forEach {
        hash = encrypt(
            gFunction(hash),
            it.toString(2).padStart(8, '0')
        )

    }
    return hash
}

fun gFunction(previousHash: String): String {
    return previousHash.map {
        if (it == '0') {
            '1'
        }
        else '0'
    }.joinToString(separator = "")
}

fun encrypt(key: String, plain: String): String {
    return plain.slice(4..7).xor(key.slice(0..3))+
            plain.slice(0..3).xor(key.slice(4..7))
}

fun String.xor(other: String): String {
    if (this.length != other.length) {
        throw IllegalArgumentException("Cannot XOR strings of different lengths: $this, $other")
    }
    return this.mapIndexed { index: Int, it: Char  ->
        if (it == other[index]) {
            '0'
        }
        else '1'
    }.joinToString(separator = "")
}
