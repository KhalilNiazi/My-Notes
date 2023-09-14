package com.niazi.mynotes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.niazi.mynotes.Fragments.UploadNotesFragment;
import com.niazi.mynotes.R;

public class Work_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);


        UploadNotesFragment uploadNotesFragment = new UploadNotesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.commit();

        transaction.replace(R.id.fragmentView,uploadNotesFragment);


        /*if (value1.equals("Inheritance")) {

            list.add(new Model_Class("1. What is Inheritance in Java?", "Ans:- Jab humy parent class k functionality child class k andar istamal karni hoti hain to hum inheritance ka istamal karte hain,iski madad se hum parent class k sare functions and variables child class may bhi istamal kar sakte hain."));
            list.add(new Model_Class("2. Why do we need to use inheritance?", "Ans:- \n" +
                    "1:- Hum code ko reuse kar sakte hain child class k andar.\n" +
                    "2:- iski madad se hum class k features barha sakte hain jaise k method Overriding.\n" +
                    "3:- iski madad se hum run time poloymorphism achive kar\n" +
                    "sakte hian.\n"));
            list.add(new Model_Class("3. What is Is-A relationship in Java?", "Ans:- Inheritance ko he is-A relationship kaha jata hai.\n" +
                    "ye extends keyword ka use kar k hum istamal kar sakte hain. aur ye code kii reusablity k liye istamal hota hai\n"));
            list.add(new Model_Class("4. What is super class and subclass?", "Ans:- wo class jiske features subclass inherit karti hai wo class super class kahlati hai,\n" +
                    "wo class jo super class k sare memebers (fields,methods,and nested classes ) inherit karti hai apne andar wo class subclas ya phir child class kahalati hai.\n"));
            list.add(new Model_Class("5. How is Inheritance implemented/achieved in Java?", "Ans:- Inheritance ko implement karne k liye hum do keyword ka istamal kar sakte hain.\n" +
                    "1:- extends : extends kii madad se hum do class ya phir \n" +
                    "interface k darmiyan inheritance create kar sakte hain.\n" +
                    "2:- implements: iski madad se hum class aur interface k darmiyan inheritance ko create kar sakte hain.\n"));



        }
*/
      /* value2.equals("Abstraction");
            list.add(new Model_Class("1. What is Abstraction in Java?", "Ans: Abstraction aik technique hai jiss may hum uss data ko hide kar dete hain jo data ko requried nahi hota.  jaise hum interface ya abstract class k andar pahle se function declare kar dete hain aur bade may unko use kar lete hain."));
            list.add(new Model_Class("2. How to achieve or implement Abstraction in Java?", "Ans: Java k andar Abstraction implement karne k do tariqay hain.\n" +
                    "a) Abstract class (0 to 100%)\n" +
                    "b) Interface (100%)\n"));

            list.add(new Model_Class(" 3. Can an abstract method be declared with private modifier?", "Ans: No, kiyon k abstract method implement hota hai child class may agar hum usko private kar dengay to usko access kaise karengay child class k object se"));
            list.add(new Model_Class("4. What is the difference between abstract class and concrete class?", "Ans: Concrete uss class ko kahte hon jo hum normal class banate hain, abstract class aur concrete class k darimyan 2 farq hain.\n" +
                    "a) hum Concrete class ka object bana kar uske methods call karte hain.\n" +
                    " abstract class k sare function hum abstract class ko extends kar k child class k objects se call karte hain.\n" +
                    "b) abstract class 0 se 100 k darmiyan abstraction ko use karti hai kiyon k aksar hum abstract class k andar simple function bhi declare kar dete hain aur unko access karne k liye humay abstract class ko extends kar k child class ka object bana kar unko call karna hota hai.\n"));
            list.add(new Model_Class("5. What is Abstract in Java?", "Ans: Java k andar Abstract non-access modifier hai jo ko class,interfaces,method,and inner class k sath applicable hota hai."));

*/

    }
}