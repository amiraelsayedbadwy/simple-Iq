package com.example.amira.thinkmore.Question_database;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 37;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    //new table chmesitry
    private static final String TABLE_CHEMISTRY = "chemistry";
    //new table myth
    private static final String TABLE_Fact="fact";
    //new table Honours
    private static final String TABLE_HONOUR= "Honour";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    //table  test

    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c
    private static final String KEY_OPTD = "optd"; // option d

    // new table chemistery
    private static final String KEY_ID2 = "qid2";
    private static final String KEY_QUES2 = "question2";
    private static final String KEY_ANSWER2 = "answer2"; // correct option
    private static final String KEY_OPTA2 = "opta2"; // option a
    private static final String KEY_OPTB2 = "optb2"; // option b
    private static final String KEY_OPTC2 = "optc2"; // option c
    private static final String KEY_OPTD2 = "optd2"; // option d
/// new table myth
   private static final String KEY_IDm = "qid3";
    private static final String KEY_QUESm = "question3";
    private static final String KEY_ANSWERm = "answer3"; // correct option
    private static final String KEY_OPTAm = "fact"; // option a
    private static final String KEY_OPTBm = "fiction"; // option b
    private static final String KEY_OPTCm = "optc3"; // option b
    // new table Honours
    private static final String KEY_IDh= "qid4";
    private static final String KEY_QUESh = "question4";
    private static final String KEY_ANSWERh= "answer4"; // correct option
    private static final String KEY_OPTAh= "opta4"; // option a
    private static final String KEY_OPTBh= "optb4"; // option b
    private static final String KEY_OPTCh= "optc4"; // option b
    private static final String KEY_OPTDh= "optd4"; // option b
    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD  +" TEXT)";
        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_CHEMISTRY + " ( "
                + KEY_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES2
                + " TEXT, " + KEY_ANSWER2 + " TEXT, " + KEY_OPTA2 + " TEXT, "
                + KEY_OPTB2 + " TEXT, " + KEY_OPTC2 + " TEXT, " + KEY_OPTD2  +" TEXT)";
        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_Fact + " ( "
                + KEY_IDm + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESm
                + " TEXT, " + KEY_ANSWERm+ " TEXT, "+KEY_OPTAm +" TEXT, "
                +KEY_OPTBm +" TEXT, "+KEY_OPTCm+" TEXT)";
        String sql4 = "CREATE TABLE IF NOT EXISTS " + TABLE_HONOUR + " ( "
                + KEY_IDh + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESh
                + " TEXT, " + KEY_ANSWERh+ " TEXT, " + KEY_OPTAh+ " TEXT, "
                + KEY_OPTBh + " TEXT, " + KEY_OPTCh + " TEXT, " + KEY_OPTDh +" TEXT)";
        db.execSQL(sql);
        db.execSQL(sql2);
       db.execSQL(sql4);
        db.execSQL(sql3);
        addQuestion();
        addQuestion2();
        addQuestion3();
        addQuestion4();
        // db.close();
    }

    private void addQuestion() {
        question q1 = new question("Fill in the sequence : 5 6 9 15 ? 40", "7", "8", "6","2", "7");
        this.addQuestion(q1);
        question q2 = new question("2+18 = ?", "18", "19", "20","90", "20");
        this.addQuestion(q2);
        question q3 = new question("10-3 = ?", "6", "7", "8","0", "7");
        this.addQuestion(q3);
        Log.e("data", String.valueOf( q3));
        question q4 = new question("5+7 = ?", "12", "13", "14","6", "12");
        this.addQuestion(q4);
        question q5 = new question("3-1 = ?", "1", "3", "2","6", "2");
        this.addQuestion(q5);
        question q6 = new question("0+1 = ?", "1", "0", "10","6", "1");
        this.addQuestion(q6);
        question q7 = new question("9-9 = ?", "0", "9", "1","6", "0");
        this.addQuestion(q7);
        question q8 = new question("3+6 = ?", "8", "7", "9","6", "9");
        this.addQuestion(q8);
        question q9 = new question("1+5 = ?", "6", "7", "5","6", "6");
        this.addQuestion(q9);
        question q10 = new question("7-5 = ?", "3", "2", "6", "6","2");
        this.addQuestion(q10);
        question q11 = new question("7-2 = ?", "7", "6", "5","6", "5");
        this.addQuestion(q11);
        question q12 = new question("3+5 = ?", "8", "7", "5","6", "8");
        this.addQuestion(q12);
        question q13 = new question("0+6 = ?", "7", "6", "5", "9","6");
        this.addQuestion(q13);
        question q14 = new question("12-10 = ?", "1", "2", "3","6", "2");
        this.addQuestion(q14);
        question q15 = new question("12+2 = ?", "14", "15", "16","6", "14");
        this.addQuestion(q15);
        question q16 = new question("2-1 = ?", "2", "1", "0", "6","1");
        this.addQuestion(q16);
        question q17 = new question("6-6 = ?", "6", "12", "0","6", "0");
        this.addQuestion(q17);
        question q18 = new question("5-1 = ?", "4", "3", "2","6", "4");
        this.addQuestion(q18);
        question q19 = new question("4+2 = ?", "6", "7", "5","6", "6");
        this.addQuestion(q19);
        question q20 = new question("5+1 = ?", "6", "7", "5","6", "6");
        this.addQuestion(q20);
        question q21 = new question("5-4 = ?", "5", "4", "1","6", "1");
        this.addQuestion(q21);
        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
        //new table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHEMISTRY);
        // Create tables again
        onCreate(db);
        //new table myth
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Fact);
        // Create tables again
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HONOUR);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());

        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);

    }

    public List<question> getAllQuestions() {
        List<question> quesList = new ArrayList<question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
       dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        // looping through all rows and adding to list
        if (cursor.getCount()>=0) {
            do {
                question quest = new question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    ///////////nw table data chemistry data
    private void addQuestion2() {
        question q1 = new question("The nucleus of an atom consists of :  ? ", "electrons and neutrons", "electrons and protons", "protons and neutrons", "All of the above", "protons and neutrons");
        this.addQuestion2(q1);
        question q2 = new question("The number of moles of solute present in 1 kg of a solvent is called its : ? ", "molality", "molarity", "normality", "formality", "molality");
        this.addQuestion2(q2);
        question q3 = new question("The most electronegative element among the following is : ?", "sodium", "bromine", "fluorine", "oxygen", "fluorine");
        this.addQuestion2(q3);
        question q4=new question("The metal used to recover copper from a solution of copper sulphate is : ?","Na","Ag","Hg","Fe","Fe");
        this.addQuestion2(q4);
        question q5=new question("The number of d-electrons in Fe2+ (Z = 26) is not equal to that of : ?","p-electrons in Ne(Z = 10)","s-electrons in Mg(Z = 12)","d-electrons in Fe(Z = 26)","p-electrons in CI(Z = 17)","p-electrons in CI(Z = 17)");
        this.addQuestion2(q5);
        question q6=new question("The metallurgical process in which a metal is obtained in a fused state is called : ?","smelting","roasting","calcinations","froth floatation","smelting");
        this.addQuestion2(q6);
        question q7=new question("The molecules of which gas have highest speed : ?","H2 at -73oC","CH4 at 300 K","N2 at 1,027oC","O2 at 0oC","H2 at -73oC");
        this.addQuestion2(q7);
        question q8=new question("The oldest rocks in the earth's crust were once molten, and came from deep inside the earth. The molten rock, called magma, spewed out in volcanic eruptions during the earth;s early life and solidified into hard rock's called : ?","granite","basalt","igneousrocks","sedimentary rocks","igneousrocks");
        this.addQuestion2(q8);
        question q9=new question("The law which states that the amount of gas dissolved in a liquid is proportional to its partial pressure is : ?","Dalton's law","Gay Lussac's law","Henry's law","H2CO3 - HCO3's law","Henry's law");
        this.addQuestion2(q9);
        question q10=new question("The main buffer system of the human blood is : ?","H2CO3-HCO3","H2CO3 - CO32-","CH3COOH - CH3COO-","NH2CONH2 - NH2CONH+","H2CO3-HCO3");
        this.addQuestion2(q10);
      question q11=new question("The gas present in the stratosphere which filters out some of the sun's ultraviolet light and provides an effective shield against radiation damage to living things is : ?","helium","ozone","oxygen","methane","ozone");
       this.addQuestion2(q11);
        question q12 =new question("The most commonly used bleaching agent is : ?","alcohol","carbon dioxide","chlorine","sodium chlorine","chlorine");
        this.addQuestion2(q12);
        question q13 =new question("The names of the scientists, Newlands, Mendeleev, and Meyer are associated with the development of : ?","atomic structure","metallurgy","periodic table of contents","discovery of elements","periodic table of contents");
        this.addQuestion2(q13);
        question q14 =new question("The maximum number of covalent formed by nitrogen is : ?","1","2","3","4","4");
        this.addQuestion2(q14);
        question q15 =new question("The metal that is usually extracted from sea water is : ?","Ca","Na","K","Mg","Mg");
        this.addQuestion2(q15);
        question q16 =new question("The method of concentrating the ore which makes use of the difference in density between ore and impurities is called : ?","liquation","leaching","levigation","magnetic separation","levigation");
        this.addQuestion2(q16);
        question q17 =new question("The inert gases are ___?_ in water : ","sparingly soluble","insoluble","soluble","None of these","sparingly soluble");
        this.addQuestion2(q17);
        question q18 =new question("The high reactivity of fluorine is due to : ?","its high electro negativity","small size of fluorine atom","availability of d-orbitals","strong F - F bond","its high electro negativity");
        this.addQuestion2(q18);
        question q19=new question("The ionisation energy of hydrogen atom in the ground state is x KJ. The energy required for an electron to jump from 2nd orbit to 3rd orbit is: ?","5x/36","5x","7.2x","x/6","5x/36");
        this.addQuestion2(q19);
        question q20 =new question("The main chemical constituent of clay is : ?","silicon oxide","aluminium borosilicate","zeolites","aluminium silicate","aluminium silicate");
        this.addQuestion2(q20);
        question q21 =new question("The ionic radii of N3-, O2-, F- and Na+ follows the order :?","N3- > O2- > F- > Na+","N3- > Na+ > O2- > F-","Na+ > O2- > N3- > F-","O2- > F- > Na+ > N3-","N3- > O2- > F- > Na+");
        this.addQuestion2(q21);


    }
    public void addQuestion2(question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES2, quest.getQUESTION());
        values.put(KEY_ANSWER2, quest.getANSWER());
        values.put(KEY_OPTA2, quest.getOPTA());
        values.put(KEY_OPTB2, quest.getOPTB());
        values.put(KEY_OPTC2, quest.getOPTC());
        values.put(KEY_OPTD2, quest.getOPTD());

        // Inserting Row
        dbase.insert(TABLE_CHEMISTRY, null, values);

    }
    public List<question> getAllQuestions2() {
        List<question> quesList2 = new ArrayList<question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHEMISTRY;
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        // looping through all rows and adding to list
        if (cursor.getCount()>=0) {
            do {
                question quest = new question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList2.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList2;
    }
    /////////Myth table
    private void addQuestion3() {
        question q1 = new question("We have strong evidence that our solar system is not the only one; we know there are many other Suns with planets orbiting them : ?", "Fact", "Fiction","Improved telescopes and detectors have led to the detection of dozens of new planetary systems within the past decade, including several systems containing multiple planets. So far, the limits of technology favor the discovery of large planets, and many are more massive than Jupiter and, surprisingly, hug their stars in scorchingly close orbits that last days instead of years. But some other systems look a lot like our own.", "Fact");
        this.addQuestion3(q1);
        question q2 = new question("Some organisms can survive in space for years -- without any kind of protective enclosure : ?", "Fact", "Fiction","A small colony of the common bacteria Streptococcus mitis stowed away for nearly three years aboard NASA's Surveyor 3, an unmanned spacecraft that landed on the moon in 1967. The crew of Apollo 12 recovered the organisms and brought them back to Earth under sterile conditions. This unplanned experiment proved that certain microorganisms can survive years of radiation exposure, the vacuum of space and deep-freeze, without any nutrient, water or energy source. Some researchers say life could have traveled from Mars to Earth inside a space rock.", "Fact");
        this.addQuestion3(q2);
        question q3 = new question(" Organisms have been found thriving in scalding water with temperatures as high as 235 degrees Fahrenheit : ?", "Fact", "Fiction","More than 50 heat-loving microorganisms, or hyperthermophiles, have been found thriving at very high temperatures in such locations as hot springs in Wyoming's Yellowstone National Park and on the walls of deep-sea hydrothermal vents. Some of these species multiply best at 221 degrees Fahrenheit, and can reproduce at up to 235 degrees. Bacteria have also been found thriving under ice near the poles, in a highly alkaline lake, and deep underground, feeding off rock.", "Fact");
        this.addQuestion3(q3);
        Log.e("data", String.valueOf( q3));
        question q4 = new question("We now have evidence that some form of life exists beyond Earth, at least in primitive form : ?", "Fact", "Fiction","While many scientists speculate that extraterrestrial life exists, so far there is no conclusive evidence to prove it. Future missions to Mars, the Jovian moon Europa and future space telescopes will search for definitive answers to this ageless question.", "Fiction");
        this.addQuestion3(q4);
        question q5 = new question(" We currently have the technology necessary to send astronauts to another star system within a reasonable time span. The only problem is that such a mission would be overwhelmingly expensive : ?",
                "Fact", "Fiction","Even the unmanned Voyager spacecraft, which left our solar system years ago at a breathtaking 37,000 miles per hour, would take 76,000 years to reach the nearest star. Because the distances involved are so vast, interstellar travel to another star within a practical time scale would require, among other things, " +
                "the ability the move a vehicle at or near the speed of light. This is beyond the reach of today's spacecraft -- regardless of funding, according to. Even so, the space agency is looking into the possibilities.", "Fiction");
        this.addQuestion3(q5);
        question q6 = new question(" All of the gas giant planets in our solar system (Jupiter, Saturn, Uranus and Neptune) have rings : ?",
                "Fact", "Fiction","Saturn's rings are the most pronounced and visible, but they aren't the only ones. Check out the rings (and clouds) of Uranus and Neptune.", "Fact");
        this.addQuestion3(q6);
        question q7 = new question("In the Star Wars films, the Imperial TIE Fighters are propelled by ion engines (TIE stands for Twin Ion Engine). While these spacecraft are fictional, real ion engines power some of today's spacecraft : ?",
                "Fact", "Fiction","Ion propulsion has long been a staple of science fiction novels, but in recent years it has been successfully tested on a number of unmanned spacecraft, notably NASA's Deep Space 1. Launched in 1998, Deep Space 1 rendezvoused with a distant asteroid and then with a comet, proving that ion propulsion could be used for interplanetary travel." +
                " And the European Space Agency just put an ion-powered probe into orbit around the Moon.", "Fact");
        this.addQuestion3(q7);
        question q8 = new question(" There is no gravity in deep space : ?", "Fact", "Fiction","If this were true, the moon would float away from the Earth, and our entire solar system would drift apart. While it's true that gravity gets weaker with distance, it can never be escaped completely, no matter how far you travel in space. Astronauts appear to experience \"zero-gravity\" because they are in continuous free-fall around the Earth. An interesting twist (or rather, nontwist) to this concept is that the gravity of a black hole works the same way. So, while anything too close to a black hole (including light) will be sucked in and hidden from view, objects at a distance from a black hole feel no greater pull than if the black hole were a star of equal mass.", "Fiction");
        this.addQuestion3(q8);
        question q9 = new question(" The basic premise of teleportation -- made famous in TV's Star Trek -- is theoretically sound. In fact, scientists have already teleported the quantum state of individual atoms from one location to another : ?",
                "Fact", "Fiction", "As early as the late 1990s, scientists proved they could teleport data using photons," +
                " but the photons were absorbed by whatever surface they struck. More recently, physicists at the University of Innsbruck in Austria and at the National Institute of Standards and Technology in Boulder, Colorado, for the first time teleported information between atoms using the principle of quantum entanglement Experts say this technology eventually could enable the invention of superfast ,quantum computers, But the bad news, at least for sci-fi fans, is that experts don't foresee being able to teleport people in this manner","Fact");
        this.addQuestion3(q9);
        question q10 = new question("Tatooine, Luke Skywalker's home planet in the Star Wars films, has two Suns -- what astronomers would call a binary star system. Scientists have discovered recently that planets really can form within such systems : ?",
                "Fact", "Fiction","Double stars, or binary systems, are common in our Milky Way galaxy. Even three-star systems exist in gravitational harmony. Among the more than 100 new planets discovered in recent years, some have been found in binary systems, including 16 Cygni B and 55 Cancri A. So far, alas, no one has found a habitable planet like Luke Skywalker's Tatooine.", "Fact");
        this.addQuestion3(q10);

        // END
    }
    public void addQuestion3(question quest) {
       // dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESm, quest.getQUESTION());
        values.put(KEY_ANSWERm, quest.getANSWER());
        values.put(KEY_OPTAm, quest.getOPTA());
        values.put(KEY_OPTBm, quest.getOPTB());
        values.put(KEY_OPTCm, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_Fact, null, values);

    }
    public List<question> getAllQuestions3() {
        List<question> quesList3 = new ArrayList<question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Fact;
       dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        // looping through all rows and adding to list
        if (cursor!=null && cursor.getCount()>=0) {
            do {
                question quest = new question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList3.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList3;
    }
    ///table honours
                                ////////////el goz darb 5als
    private void addQuestion4() {
        question q1 = new question("B. C. Roy Award is given in the field of : ?", "Music", "Journalism", "Medicine","Environment", "Environment");
        this.addQuestion4(q1);
        question q2 = new question("In which year was Pulitzer Prize established ?", "1917", "1918", "1922","1928", "1917");
        this.addQuestion4(q2);
        question q3 = new question("Gandhi Peace Prize for the year 2000 was awarded to the former President of South Africa along with ? ", "Sathish Dawan", "C. Subramanian", "Grameen Bank of Bangladesh","World Healt Organisation", "Grameen Bank of Bangladesh");
        this.addQuestion4(q3);
        Log.e("data", String.valueOf( q3));
        question q4 = new question("Who has been awarded the first lifetime Achievement Award for his/her contribution in the field of Cinema?", "Ashok Kumar", "Hou Hsio-hsein", "Akiro Burosova","Bernardo Burtolucci", "Ashok Kumar");
        this.addQuestion4(q4);
        question q5 = new question("The prestigious Ramon Magsaysay Award was conferred was conferred upon Ms. Kiran Bedi for her excellent contribution to which of the following fields?", "Literature", "Community Welfare", "Government Service","Journalism", "Government Service");
        this.addQuestion4(q5);
        question q6 = new question("Which of the following societies has instituted an award for an outstanding parliamentarian?", "Jamanlal Bajaj Foundation", "Institute of Constitutional and Parliamentary Studies", "G. B. Pant Memorial Society","R. D. Birla samara Kosh", "G. B. Pant Memorial Society");
        this.addQuestion4(q6);
        question q7 = new question("Which is the highest gallantry award in India?", "Param Vishishtat Seva Medal", "Param Vir Chakra", "Kirti Chakra","Vir Chakra", "Param Vir Chakra");
        this.addQuestion4(q7);
        question q8 = new question("Which state gives Mewar Award?", "Haryana", "Delhi", "Kirti Chakra","Punjab", "Punjab");
        this.addQuestion4(q8);
        question q9 = new question("Who is the first Asian Winner of Nobel Prize?", "C. V. Raman", "Rajiv Gandhi", "Rabindranath Tagore","Mother Teresa", "Rabindranath Tagore");
        this.addQuestion4(q9);
        question q10 = new question("The first Indian to receive Noble Prize in Literature was ?", "Mother Teresa", "C. V. Raman", "Rabindranath Tagore", "Sarojini Naidu","Rabindranath Tagore");
        this.addQuestion4(q10);
        question q11 = new question("The first recipient of Rajiv Gandhi's 'Khel Ratna' award is ?", "Vishwanathan Anand", "Leander Peas", "Kapil Dev","Limba Ram", "Vishwanathan Anand");
        this.addQuestion4(q11);

        // END
    }
    // Adding new question
    public void addQuestion4(question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESh, quest.getQUESTION());
        values.put(KEY_ANSWERh, quest.getANSWER());
        values.put(KEY_OPTAh, quest.getOPTA());
        values.put(KEY_OPTBh, quest.getOPTB());
        values.put(KEY_OPTCh, quest.getOPTC());
        values.put(KEY_OPTDh, quest.getOPTD());

        // Inserting Row
        dbase.insert(TABLE_HONOUR, null, values);

    }

    public List<question> getAllQuestions4() {
        List<question> quesList6 = new ArrayList<question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HONOUR;
        dbase = getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        // looping through all rows and adding to list
        if (cursor.getCount()>=0) {
            do {
                question quest = new question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList6.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList6;
    }




}
