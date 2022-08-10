package com.atharva.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView dice1 = findViewById(R.id.imgDice1);
        ImageView dice2 = findViewById(R.id.imgDice2);

        //creating array of imageView
        int[] diceImages = {R.drawable.dice1 ,R.drawable.dice2 ,R.drawable.dice3 ,R.drawable.dice4
                ,R.drawable.dice5 ,R.drawable.dice6}; //setting dice images index wise

        //Declaring a variable of type button.
        Button rollTheDice = findViewById(R.id.button1);

        //setting sound for the dice roll
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dicesound);

        //setting onLClick method for button click
        rollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating object for generating natural numbers.
                Random rndObject = new Random();
                int rndNumber = rndObject.nextInt(6); //upper bound is 6 so // 0..5 //
                Log.i("Tag",rndNumber + "");

                //generating random images of dice Array with reference to random number
                dice1.setImageResource(diceImages[rndNumber]);

                //setting random Number for second image
                rndNumber = rndObject.nextInt(6); //0..5//
                dice2.setImageResource((diceImages[rndNumber]));

                //codes for generating the animation
                //for dice image 1
                YoYo.with(Techniques.Shake)
                        .duration(600)
                        .repeat(0)
                        .playOn(dice1);

                //for dice image 2
                YoYo.with(Techniques.Shake)
                        .duration(600)
                        .repeat(0)
                        .playOn(dice2);

                //calling the sound function after clicking on button
                mp.start();

            }
        });
    }
}