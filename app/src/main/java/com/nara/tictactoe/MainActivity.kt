package com.nara.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var turn = 1
    var marktick = Array(3,{IntArray(3)})
    fun tick(view: View){
        when(view.id){
            R.id.b1 -> {b1.text = turncheck(0,0);b1.isEnabled = false}
            R.id.b2 -> {b2.text = turncheck(0,1);b2.isEnabled = false}
            R.id.b3 -> {b3.text = turncheck(0,2);b3.isEnabled = false}
            R.id.b4 -> {b4.text = turncheck(1,0);b4.isEnabled = false}
            R.id.b5 -> {b5.text = turncheck(1,1);b5.isEnabled = false}
            R.id.b6 -> {b6.text = turncheck(1,2);b6.isEnabled = false}
            R.id.b7 -> {b7.text = turncheck(2,0);b7.isEnabled = false}
            R.id.b8 -> {b8.text = turncheck(2,1);b8.isEnabled = false}
            R.id.b9 -> {b9.text = turncheck(2,2);b9.isEnabled = false}
        }
        result.text = check_win();
        if (result.text != "") reset_start(false)
    }

    fun reset_start(state:Boolean){
        b1.isEnabled = state;
        b2.isEnabled = state
        b3.isEnabled = state
        b4.isEnabled = state
        b5.isEnabled = state
        b6.isEnabled = state
        b7.isEnabled = state
        b8.isEnabled = state
        b9.isEnabled = state
    }

    fun check_win(): String {
        if (marktick[0][0] == marktick[0][1] && marktick[0][1] == marktick[0][2] && (marktick[0][1] == 1 || marktick[0][1] == 2))
            return "Player ${marktick[0][1]} Win !"
        else if (marktick[1][0] == marktick[1][1] && marktick[1][1] == marktick[1][2] && (marktick[0][1] == 1 || marktick[0][1] == 2))
            return "Player ${marktick[1][1]} Win !"
        else if (marktick[2][0] == marktick[2][1] && marktick[2][1] == marktick[2][2] && (marktick[2][1] == 1 || marktick[0][2] == 2))
            return "Player ${marktick[2][1]} Win !"
        else if (marktick[0][0] == marktick[1][1] && marktick[1][1] == marktick[2][2] && (marktick[1][1] == 1 || marktick[1][1] == 2))
            return "Player ${marktick[1][1]} Win !"
        else if (marktick[0][2] == marktick[1][1] && marktick[1][1] == marktick[2][0] && (marktick[1][1] == 1 || marktick[1][1] == 2))
            return "Player ${marktick[1][1]} Win !"
        else if (marktick[0][0] == marktick[1][0] && marktick[1][0] == marktick[2][0] && (marktick[1][0] == 1 || marktick[1][0] == 2))
            return "Player ${marktick[1][0]} Win !"
        else if (marktick[0][1] == marktick[1][1] && marktick[1][1] == marktick[2][1] && (marktick[1][1] == 1 || marktick[1][1] == 2))
            return "Player ${marktick[1][1]} Win !"
        else if (marktick[0][2] == marktick[1][2] && marktick[1][2] == marktick[2][2] && (marktick[1][2] == 1 || marktick[1][2] == 2))
            return "Player ${marktick[1][2]} Win !"
        else if (check_draw())
            return "Players Draw"
        return ""
    }
    fun check_draw():Boolean{
        for (i in 0..2){
            for (j in 0..2){
                if (marktick[i][j] == 0) return false else continue
            }
        }
        return true
    }

    fun turncheck(a: Int, b: Int):String{
        if (turn == 1) { turn = 2; marktick[a][b] = 1; return "0"}else {turn = 1;marktick[a][b] = 2; return "X"}
    }
}
