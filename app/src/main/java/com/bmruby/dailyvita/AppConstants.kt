package com.bmruby.dailyvita

class AppConstants {
    companion object{
         val healthConcerns = listOf<Item>(
            Item(1,"Sleep"),
            Item(2,"Immunity"),
            Item(3,"Stress"),
            Item(4,"Joint Support"),
            Item(5,"Digestion"),
            Item(6,"Mood"),
            Item(7,"Energy"),
            Item(8,"Hair, Nail, Skin"),
            Item(9,"Weight Loss"),
            Item(10,"Weight Loss"),
        )
        val diet = listOf<Diet>(
            Diet(0,"None",""),
            Diet(1,"Vegan","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Diet(2,"Vegaterian","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Diet(3,"Plant based","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Diet(4,"Pescaterian","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Diet(5,"Strict Paleo","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
            Diet(6,"Ketogenic","Lorem Ipsum is simply dummy text of the printing and typesetting industry."),
        )
        val allergic = listOf(
            Item(1,"Milk"),
            Item(2,"Meat"),
            Item(3,"Weat"),
            Item(4,"Nasacort"),
            Item(5,"Nasalide"),
            Item(6,"Nasaonex"),
        )
    }
}
