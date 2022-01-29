package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        solve("EarthNaja")
//        makeComplement("GTAT")
        deleteNth(intArrayOf(1, 2, 1, 4, 4, 4), 1)
    }

    fun deleteNth(elements: IntArray, maxOcurrences: Int): IntArray {
        val x = ArrayList<Int>()
        for (e in elements) {
            if (x.count { it == e } < maxOcurrences) {
                x.add(e)
            }
        }
        Log.i("testnaja", x.toString())
        return x.toIntArray()
    }

    //สลับค่า string รายตัว
    //การทำงานคือ dna.map ตัวอย่างคืนค่า List[T,A,G,C]
    //เสร็จแล้วจะเอา List แต่ละตัวมาแปลงเป็น String (.joinToString) โดยขั้นด้วย "" หรือเครื่องหมายอะไรก็ได้ที่ต้องการ
    fun makeComplement(dna: String) = dna.map {
        when (it) {
            'A' -> 'T'
            'T' -> 'A'
            'C' -> 'G'
            'G' -> 'C'
            else -> it
        }
    }.joinToString("")

    //จัดระเบียบพิมเล็ก / พิมใหญ่
    //การทำงานคือนับจำนวนที่เป็นพิมพ์เล็กว่าเป็นส่วนมากของทั้งประโยคหรือไม่
    private fun solve(s: String): String = if (s.count { it.isLowerCase() } >= s.length / 2.0) {
        s.toLowerCase()
    } else s.toUpperCase()
}