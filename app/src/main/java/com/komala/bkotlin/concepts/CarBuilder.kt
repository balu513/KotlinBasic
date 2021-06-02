package com.komala.bkotlin.concepts

class CarBuilder(val model: String? = null, val year: Int = 0) {
//    private constructor(builder: Builder) : this(builder.model, builder.year)
//
//    class Builder {
//        var model: String? = null
//            private set
//
//        var year: Int = 0
//            private set
//
//        fun model(model: String) = apply { this.model = model }
//
//        fun year(year: Int) = apply { this.year = year }
//
//        fun build() = Car(this)
//    }
    private constructor(builder: Builder) : this(builder.model, builder.year)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {
        var model: String? = null
        var year: Int = 0

        fun build() = CarBuilder(this)
    }
}