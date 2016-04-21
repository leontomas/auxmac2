package info.androidhive.materialdesign.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import info.androidhive.materialdesign.model.Dictionary;
import info.androidhive.materialdesign.model.Question;
import info.androidhive.materialdesign.model.QuestionImage;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASEVERSION = 53;
    public static final String DATABASENAME = "AUXMAC";

    public static final String TBL_QUESTION = "tbl_question";

    public static final String KEY_ID = "id";
    public static final String KEY_QUESTION = "question";
    public static final String KEY_LESSON = "lesson";
    public static final String KEY_CHOICEA = "choicea";
    public static final String KEY_CHOICEB = "choiceb";
    public static final String KEY_CHOICEC = "choicec";
    public static final String KEY_ANSWER = "answer";
    public static final String KEY_ADDINFO = "addinfo";

    public static final String TBL_DICTIONARY = "tbl_dictionary";

    public static final String KEY_DICID = "dic_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_DESC = "description";

    public static final String TBL_SOUND = "tbl_sound";

    public static final String KEY_SOUND_ID = "sound_id";
    public static final String KEY_SOUND = "sound";

    public static final String TBL_SUMMARY = "testsummary";

    public static final String KEY_SUMMARY_ID = "summary_id";
    public static final String KEY_SUMMARY_QUESTION = "summary_question";
    public static final String KEY_SUMMARY_ANSWER = "summary_answer";
    public static final String KEY_SUMMARY_ADDINFO = "summary_addinfo";
    public static final String KEY_SUMMARY_STATUS = "summary_status";

    public static final String TBL_IMAGE_SUMMARY = "testimagesummary";

    public static final String KEY_IMAGE_SUMMARY_ID = "img_summary_id";
    public static final String KEY_IMAGE_SUMMARY_ANSWER = "img_summary_answer";
    public static final String KEY_IMAGE_SUMMARY_STATUS = "img_summary_status";

    public static final String TBL_SCORE = "tbl_score";

    public static final String KEY_SCORE_ID = "score_id";
    public static final String KEY_GAME_TYPE = "game_type";
    public static final String KEY_PLAYER_NAME = "player_name";
    public static final String KEY_SCORE_LESSON_NAME = "lesson_name";
    public static final String KEY_SCORE = "score";
    public static final String KEY_DATE_TAKEN = "date_taken";

    public static final String TBL_QUIZIMAGE = "tbl_quizimage";

    public static final String KEY_IMG_ID = "img_id";
    public static final String KEY_IMG_CHOICEA = "img_choicea";
    public static final String KEY_IMG_CHOICEB = "img_choiceb";
    public static final String KEY_IMG_CHOICEC = "img_choicec";
    public static final String KEY_IMG_ANSWER = "img_answer";
    public static final String KEY_IMG_TYPE = "img_type";

    public SQLiteDatabase dbase;

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_QUESTION + " TEXT NOT NULL, "
                + KEY_LESSON + " TEXT NOT NULL, "
                + KEY_CHOICEA + " TEXT NOT NULL, "
                + KEY_CHOICEB + " TEXT NOT NULL, "
                + KEY_CHOICEC + " TEXT NOT NULL, "
                + KEY_ANSWER + " TEXT NOT NULL, "
                + KEY_ADDINFO + " TEXT NOT NULL ) ";

        db.execSQL(sql);
        addQuestion();

        String dic_sql = "CREATE TABLE IF NOT EXISTS " + TBL_DICTIONARY + " ( "
                + KEY_DICID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_WORD + " TEXT NOT NULL, "
                + KEY_DESC + " TEXT NOT NULL ) ";
        db.execSQL(dic_sql);
        addDictionary();

        String sound_sql = "CREATE TABLE IF NOT EXISTS " + TBL_SOUND + " ( "
                + KEY_SOUND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_SOUND + " TEXT NOT NULL ) ";
        db.execSQL(sound_sql);
        insertSound();

        String testsum_sql = "CREATE TABLE IF NOT EXISTS " + TBL_SUMMARY + " ( "
                + KEY_SUMMARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_SUMMARY_QUESTION + " TEXT NOT NULL, "
                + KEY_SUMMARY_ANSWER + " TEXT NOT NULL, "
                + KEY_SUMMARY_ADDINFO + " TEXT NOT NULL, "
                + KEY_SUMMARY_STATUS + " TEXT NOT NULL ) ";
        db.execSQL(testsum_sql);

        String testimagesum_sql = "CREATE TABLE IF NOT EXISTS " + TBL_IMAGE_SUMMARY + " ( "
                + KEY_IMAGE_SUMMARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_IMAGE_SUMMARY_ANSWER + " TEXT NOT NULL, "
                + KEY_IMAGE_SUMMARY_STATUS + " TEXT NOT NULL ) ";
        db.execSQL(testimagesum_sql);

        String score_sql = "CREATE TABLE IF NOT EXISTS " + TBL_SCORE + " ( "
                + KEY_SCORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_GAME_TYPE + " TEXT NOT NULL, "
                + KEY_PLAYER_NAME + " TEXT NOT NULL, "
                + KEY_SCORE_LESSON_NAME + " TEXT NOT NULL, "
                + KEY_SCORE + " INTEGER NOT NULL, "
                + KEY_DATE_TAKEN + " TEXT NOT NULL ) ";
        db.execSQL(score_sql);

        String quiz_aux_sql = "CREATE TABLE IF NOT EXISTS " + TBL_QUIZIMAGE + " ( "
                + KEY_IMG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_IMG_CHOICEA + " TEXT NOT NULL, "
                + KEY_IMG_CHOICEB + " TEXT NOT NULL, "
                + KEY_IMG_CHOICEC + " TEXT NOT NULL, "
                + KEY_IMG_ANSWER + " TEXT NOT NULL, "
                + KEY_IMG_TYPE + " TEXT NOT NULL ) ";
        db.execSQL(quiz_aux_sql);
        addQuestionImage();
    }

    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TBL_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_DICTIONARY);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_SOUND);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_SUMMARY);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_IMAGE_SUMMARY);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_SCORE);
        db.execSQL("DROP TABLE IF EXISTS " + TBL_QUIZIMAGE);
        onCreate(db);
    }

    private void addQuestion() {

        /************************************************************* Aux Engine ********************************************************************/

        Question q1 = new Question(0, "How often should the filter element in the rocker arm lubricating oil system be cleaned?", "Aux Engine", "At least once a week", "Daily", "At least once every second week", "Daily", "https://www.youtube.com/watch?v=_KtsBe34GHk");
        this.addQuestion(q1);
        Question q2 = new Question(1, "What is the reason we must include manual checking of the main air starting valve pipes in routine duties?", "Aux Engine", "It indicates a defect starting valve which must be replaced.", "The starting air bottle has been drained", "To  identify any increase in temperature", "To  identify any increase in temperature", "Starting Air System \n" +
                "Routine duties must include the manual checking of the main air starting valve pipes for any increase in temperature, which would indicate leakage of combustion gasses into the system. It is particularly relevant during manoeuvring when the main air starting reservoirs are open to the system despite the existence of non-return valves and other devices.\n" +
                "\n" +
                "It is absolutely essential that if an air starting valve is in any way suspect that immediate action is taken i.e. shutting the fuel off the unit in accordance with the manufacturer's instructions, \"gagging\" the valve shut, and replacing the valve at the first opportunity.\n" +
                "\n" +
                "Only in exceptional circumstances and according to the Master's authority is the main engine to be operated with leaking air starting system valves.\n" +
                "\n" +
                "Air starting systems usually incorporate two or more air reservoirs. According to experience with the main engine plant, the Chief Engineer is to issue standing instructions regarding the air reservoirs which are to be online during manoeuvring.\n");
        this.addQuestion(q2);
        Question q3 = new Question(2, "An excessive noise level may lead to except:", "Aux Engine", "Permanent reduced hearing", "Undesired heating effects", "Buzzing in the ears", "Undesired heating effects", "Necessary protective measures will vary from ship to ship. Engine operators and anyone entering the engine room while the engine is running should protect their hearing with the means available.\n" +
                "An excessive noise level may lead to:\n" +
                "•\tPermanent reduced hearing\n" +
                "•\tBuzzing in the ears\n" +
                "•\tTiredness, stress etc\n" +
                "•\tOther effects as loss of balance, loss of awareness, etc.\n");
        this.addQuestion(q3);
        Question q4 = new Question(3, "This type of Hazard advised you to always be aware of what parts of the engine you touch when working on or by the engine.", "Aux Engine", "Thermal Hazard", "Electrical Hazard", "Noise Hazard", "Thermal Hazard", "Always be aware of what parts of the engine you touch when working on or by the engine.\n" +
                "Thermal Hazards\n");
        this.addQuestion(q4);
        Question q5 = new Question(4, "The engine can be stopped from the PLC-cabinet or from the engine panel with a switch marked: STOP", "Aux Engine", "Auto", "Manual", "Auto-pilot", "Manual", "Manual stop\n" +
                "The engine can be stopped from the PLC-cabinet or from the engine panel with a switch marked: \"STOP\".\n" +
                "This will make the actuator set the fuel rack to zero position, which will result in an immediate stop.\n" +
                "•\tWhen the engine is idle this is regarded as a normal stop.\n" +
                "•\t When the engine is running on load it will be regarded as an emergency stop, because the abrupt halt may cause damage to the engine and generator.\n");
        this.addQuestion(q5);
        Question q6 = new Question(5, "What requirements have to be met to carry out a cold standby starting on MDO?", "Aux Engine", "Jacket cooling water above 50°C.", "Jacket cooling water above 50°C and nozzle oil temperature above 80°C.", "Jacket cooling water above 0°C.", "Jacket cooling water above 0°C.", "Start on MDO:\n" +
                "•\tAbove 50°C:...............................Warm standby starting\n" +
                "•\tBetween 0°C and 50°C:.............................Cold starting\n" +
                "•\tBelow 0°C Emergency starting\n");
        this.addQuestion(q6);
        Question q7 = new Question(6, "What requirements have to be met to start on HFO?", "Aux Engine", "Jacket cooling water above 50°C.", "Jacket cooling water above 50°C and nozzle oil temperature above 80°C.", "Jacket cooling water above 80°C.", "Jacket cooling water above 50°C.", "");
        this.addQuestion(q7);
        Question q8 = new Question(7, "To check starting air pressure make sure that the start air pressure is as close to __ bars possible.", "Aux Engine", "10", "30", "20", "30", "Check starting air pressure:\n" +
                "Make sure that the start air pressure is as close to 30 bars as possible, and minimum 15 bars.\n");
        this.addQuestion(q8);
        Question q9 = new Question(8, "What should you do to start the engine?", "Aux Engine", "Check all manometers", "Check all procedures", "Reset button", "Check all manometers", "Start the engine\n" +
                "Check all manometers\n" +
                "•\tTachometer\n" +
                "•\tHour counter\n" +
                "•\tIndicator, Exhaust Temperature\n" +
                "•\tStart button\n" +
                "•\tStop button\n" +
                "•\tPlug\n" +
                "•\tReset button, auto stop\n" +
                "•\tKey switch\n" +
                "•\tInterlock indicator\n" +
                "•\tManometers\n");
        this.addQuestion(q9);
        Question q10 = new Question(9, "Inspection of wire insulation should be performed?", "Aux Engine", "Weekly", "Regularly", "Monthly", "Regularly", "•\tInternal inspection and maintenance of components in the electrical system should only be performed by certified personnel\n" +
                "•\tInspection of wire insulation should be performed regularly\n" +
                "Electrical Hazards\n");
        this.addQuestion(q10);

        /************************************************************* Fresh Water Generator ********************************************************************/

        Question q11 = new Question(10, "The fresh water produced is delivered to a tank by a:", "Fresh Water Generator", "Separately installed fresh water pump", "Fresh water ejector", "Built-in fresh water pump", "Built-in fresh water pump", "Installation\n" +
                "The JW26-c freshwater generator is designed for automatic operation in periodically unmanned\n" +
                "Engine rooms and other automated operations.\n" +
                "The heating medium is either engine jacket cooling water or a closed circuit heated by steam. The ejector pump is installed separately and has a separate suction from the sea chest. This pump supplies coolant in the form of seawater to the condenser, feed water for evaporation and water for the combined brine/air ejector. The built in freshwater pump pumps the fresh water produced into the tank.\n");
        this.addQuestion(q11);
        Question q12 = new Question(11, "The evaporation temperature 40 - 50 °C corresponds to a vacuum of:", "Fresh Water Generator", "80-85%", "70-75%", "90-95%", "90-95%", "The feed water to be distilled is taken from the sea cooling water outlet of the condenser. It enters the evaporator where it evaporates at about 40-50°C as it passes between the plates heated by the heating medium.\n" +
                "The evaporating temperature corresponds to a vacuum of 90-95%, maintained by the brine/air ejector. The vapors generated pass through a demister where any drops of seawater entrained are removed and fall due to gravity into the brine sump in the bottom of the distiller chamber.\n");
        this.addQuestion(q12);
        Question q13 = new Question(12, "The feed-water to be distilled is taken from:", "Fresh Water Generator", "The fresh water cooling system", "The sea cooling water inlet of the condenser", "The sea cooling water outlet of the condenser", "The sea cooling water outlet of the condenser", "The feed water to be distilled is taken from the sea cooling water outlet of the condenser. It enters the evaporator where it evaporates at about 40-50°C as it passes between the plates heated by the heating medium.\n" +
                "The evaporating temperature corresponds to a vacuum of 90-95%, maintained by the brine/air ejector. The vapors generated pass through a demister where any drops of seawater entrained are removed and fall due to gravity into the brine sump in the bottom of the distiller chamber.\n");
        this.addQuestion(q13);
        Question q14 = new Question(13, "The ejector pumps supplies coolant in the form of seawater to the condenser:", "Fresh Water Generator", "Feed-water for the evaporator and water for the combined brine/air ejector", "Water for combined brine/air ejector only", "Feed-water for the evaporator only", "Feed-water for the evaporator and water for the combined brine/air ejector", "Installation\n" +
                "The JW26-c freshwater generator is designed for automatic operation in periodically unmanned\n" +
                "Engine rooms and other automated operations.\n" +
                "The heating medium is either engine jacket cooling water or a closed circuit heated by steam. The ejector pump is installed separately and has a separate suction from the sea chest. This pump supplies coolant in the form of seawater to the condenser, feed water for evaporation and water for the combined brine/air ejector. The built in freshwater pump pumps the fresh water produced into the tank.\n");
        this.addQuestion(q14);
        Question q15 = new Question(14, "Drops of sea water removed by demister:", "Fresh Water Generator", "Fall due to gravity into the evaporation section", "Fall due to gravity into the brine sump", "Are removed by the fresh water pump", "Fall due to gravity into the brine sump", "The evaporating temperature corresponds to a vacuum of 90-95%, maintained by the brine/air ejector. The vapors generated pass through a demister where any drops of seawater entrained are removed and fall due to gravity into the brine sump in the bottom of the distiller chamber.\n" +
                "The clean freshwater vapors continue to the condenser, where they condense into fresh water as they pass between the cold plates cooled by the sea cooling water. In order to continuously check the quality of the fresh water produced, a salino-meter is provided together with an electrode unit fitted on the fresh water pump delivery side. If the salinity of the fresh water produced exceeds the permitted maximum value, the solenoid valve and alarm are then activated to automatically dump the fresh water produced into the bilge.\n");
        this.addQuestion(q15);
        Question q16 = new Question(15, "Open the hot water inlet and outlet valves from the jacket cooling system when?", "Fresh Water Generator", "When there is a minimum of 90% vacuum", "When there is a maximum of 90% vacuum", "When there is a minimum of 70% vacuum", "When there is a minimum of 90% vacuum", "Point 6\n" +
                "When there is a minimum of 90% vacuum, open the hot water inlet and outlet valves / from the jacket cooling system.\n" +
                "Wait for the vacuum to build up. Vacuum should be at least 90% which can be seen on the gauge present on the generator. Generally the time taken for the generation of vacuum is about 10 minutes.\n");
        this.addQuestion(q16);
        Question q17 = new Question(16, "In order to obtain the specified flow of hot water it is necessary:", "Fresh Water Generator", "To close the hot water inlet valve", "To adjust the by-pass valve", "To close the hot water outlet valve", "To adjust the by-pass valve", "Point 7\n" +
                "Start the hot water supply to the evaporator section by adjusting the by-pass valves, until the desired jacket water temperature difference is reached which is 80°C for the inlet, and for the outlet 72°C. The boiling temperature inside the separator vessel ought to be about 45°C.\n");
        this.addQuestion(q17);
        Question q18 = new Question(17, "This is the last phase in stopping procedure of Fresh Water Generator.", "Fresh Water Generator", "Close the overboard valve for combined air/brine ejector", "Close the valves on the suction", "Stop the ejector pump", "Close the overboard valve for combined air/brine ejector", "http://www.marineinsight.com/tech/proceduresmaintenance/converting-seawater-to-freshwater-on-a-ship-fresh-water-generator-explained/");
        this.addQuestion(q18);
        Question q19 = new Question(18, "When you wish to stop the Fresh Water Generator, what needs to be stop first?", "Fresh Water Generator", "Outlet valve", "Fresh water ejector", "Outlet valve", "Outlet valve", "http://www.marineinsight.com/tech/proceduresmaintenance/converting-seawater-to-freshwater-on-a-ship-fresh-water-generator-explained/");
        this.addQuestion(q19);
        Question q20 = new Question(19, "After setting the main switch to position 0. The next phase is?", "Fresh Water Generator", "Turn the sec alarm off", "Open the air valve", "Close the air valve", "Open the air valve", "Point 4\n" +
                "Set the main switch to position 0.\n" +
                "\n" +
                "\n" +
                "Point 5\n" +
                "Open the air valve\n");
        this.addQuestion(q20);

        /************************************************************* Steering Gear ********************************************************************/

        Question q21 = new Question(20, "What are the parameters most essential for the rudder torque?", "Steering Gear", "Shape of the hull, propeller rotation and waves", "Rudder arrangement, size of the rudder and the vessel’s speed", "The vessel’s dead weight and tonnage", "Rudder arrangement, size of the rudder and the vessel’s speed", "In order to move the rudder, the steering gear has to create a certain torque (measured in kilo Newton meters.)\n" +
                "The torque requirement is given by the class rules to ensure safe maneuverability of the vessel. The size and shape of the rudder, and also the speed of the vessel is taken into consideration.\n");
        this.addQuestion(q21);
        Question q22 = new Question(21, "Which one of these three rudders gives the best maneuverability, given they have the same size?", "Steering Gear", "Spade rudder with normal profile", "Semi-spade rudder", "Flap rudder", "Flap rudder", "This type of rudder is used when very good maneuverability is required. The rear fin “exaggerates” the movement of the rudder, making the rudder more effective (increasing the side lift)\n" +
                "https://www.youtube.com/watch?v=UDBeCqzYO5k\n");
        this.addQuestion(q22);
        Question q23 = new Question(22, "What is the limit in size for tankers to use only one standard steering gear?", "Steering Gear", "10,000 GT (Gross tonnage)", "100,000 DWT (Deadweight tons)", "100,000 NT (Net tonnage)", "100,000 DWT (Deadweight tons)", "http://www.scribd.com/doc/83656152/Steering-Gear#scribd");
        this.addQuestion(q23);
        Question q24 = new Question(23, "If Ram tyoe uses cylinder pistons. Rotary vane uses ____?", "Steering Gear", "Vane", "Surface", "Pressure", "Pressure", "Basically there are two types of electro hydraulic steering gear working principles:\n" +
                "The ram (or cylinder-) type and the rotary vane type.\n" +
                "The working principles of the two are very similar. A strong slow movement of a mechanical surface is created by the use of high oil pressure.\n" +
                "-Ram type uses cylinder pistons.\n" +
                "-Rotary vane uses pressure working on the side of a vane (or wing)\n" +
                "On the ram type the piston is connected by a ram (or nod) to a tiller, and the tiller is fixed connected to the rudder stock, creating the rotating movement. On the rotary vane, the vane is fixed to a boss (hub) that is fixed directly to the stock.\n");
        this.addQuestion(q24);
        Question q25 = new Question(24, "It serves as the outer boundaries, side and bottom of the pressure cambers.", "Steering Gear", "Rotor", "Housing", "Rudder stock", "Housing", "Serves as the outer bounderies, side and bottom of the pressure cambers.");
        this.addQuestion(q25);
        Question q26 = new Question(25, "This is the moving part of the actuator.", "Steering Gear", "Rotor", "Housing", "Rudder stock", "Rotor", "This is the moving part of the actuator. It turns the rudderstock when the hydraulic pressure increseas on either side of its vanes. It is fitted with spring loaded cast iron bars. These are not exposed to wear.");
        this.addQuestion(q26);
        Question q27 = new Question(26, "This is the connecting shaft bwtween the rotor and the rudder.", "Steering Gear", "Rotor", "Housing", "Rudder stock", "Rudder stock", "This is the connecting shaft between the rotor and the rudder.");
        this.addQuestion(q27);
        Question q28 = new Question(27, "The steering mode, in which the rudder angle is pre-set manually and kept in position automatically is called?", "Steering Gear", "Auto pilot", "Non-follow up", "Follow up", "Follow up", "http://www.sperrymarine.com/marine-steering-systems/naviguide-4000/configurations");
        this.addQuestion(q28);
        Question q29 = new Question(28, "In case of any steering gear alarm occurs this can only be acknowledged from?", "Steering Gear", "Wheel house", "Bridge", "Bilge", "Wheel house", "http://www.wisegeek.com/what-is-a-wheelhouse.htm");
        this.addQuestion(q29);
        Question q30 = new Question(29, "The ship will automatically find its way to a pre-set route", "Steering Gear", "Auto pilot", "Non-follow up", "Follow up", "Auto pilot", "http://www.sperrymarine.com/marine-steering-systems/naviguide-4000/configurations");
        this.addQuestion(q30);

        /************************************************************* Operation of Generators ********************************************************************/

        Question q31 = new Question(30, "It is said “if a winding is rotated in a homogeneous magnetic field a voltage will be induced in the winding” Which means that the rate of flux change determines the strength of the _________.", "Operation of Generators", "winding", "volumn", "voltage", "voltage", "What is flux? Flux can be described as the magnetic field which crosses the winding. As we can see, at this position, the maximum magnetic field crosses the winding, which means maximum flux.\n" +
                "\n" +
                "According to Faradays Law, the induced voltage will be at a minimum when the flux crossing the winding is at maximum because the rate of flux change is at its minimum. The green depicts the induced voltage while the red line depicts the actual flux\n");
        this.addQuestion(q31);
        Question q32 = new Question(31, "If we study this generator during one revolution, we will see that the generator will produce _________ of sinus curves instead of one as for the 2-pole, one winding generator.", "Operation of Generators", "three sets", "two sets", "four sets", "two sets", "Practically, all generators are designed as three phase generators. The three winding sets are mounted with a 120 degrees phase shift around the stator. This will give the three phases with the induced voltage 120 degrees shifted relative to each other.");
        this.addQuestion(q32);
        Question q33 = new Question(32, "It is not found onboard modern vessels today, all voltage regulators are based upon the same principle and can therefore be considered an introduction to the modern brushless automatic excitation systems.", "Operation of Generators", "brush generator", "brushless generator", "brush sling ring", "brush generator", "Bush / Slip Ring Generator\n" +
                "1.\tBrushes and slip ring cause attentiveness due to wear and dirt.\n" +
                "2.\tIt is difficult to adjust the nominal voltage (must change the reactance for the current limiters)\n" +
                "3.\tThe voltage is to certain grade depended on the power factor on the loads and the prime movers rational speed.\n" +
                "Brushless Generator\n" +
                "\n" +
                "The brushless generator has its own excitation generator mounted directly on the generator shaft.The rectifier and the excitation machine’s armature winding are part of the generators rotating parts. The excitation winding of the excitation machine represents the stator. The response time is a little slower than the brush / slip ring generator without AVR because it has more components in the system which delay the response, but does not have the disadvantages mentioned under the brush / slip ring system.\n");
        this.addQuestion(q33);
        Question q34 = new Question(33, "It is necessary to ensure equal excitation current to the generators which will ensure equal loadsharing.", "Operation of Generators", "insulator", "regulator", "reactor", "regulator", "This was not necessary for the brush / slipping generators as the magnetization windings were accessible so that we could parallel the excitation current wires to avoid unequal load sharing. This is not the case for the brushless generator, so we have to provide the generators with electronic voltage regulators to achieve equal reactive load sharing.");
        this.addQuestion(q34);
        Question q35 = new Question(34, "This compares the actual voltage with the setpoint voltage. The result of the comparison gives an output to the thyristor which will parallel shift drop until UG=UN.", "Operation of Generators", "regulator", "comparator", "thyristor", "comparator", "For a single generator, the current transformer is not necessary because the generator takes the entire load anyway, and therefore some manufacturers have a switch, which disconnects the current transformer at single operation. The regulator then regulates against voltage alone.");
        this.addQuestion(q35);
        Question q36 = new Question(35, "Normally the power factor on the generator is?", "Operation of Generators", "0,9 - 1,0", "0,6 - 0,7", "0,8 - 0,9", "0,8 - 0,9", "1.\tPower factor can be leading or lagging, or in some cases, at unity. \n" +
                "2.\tA leading power factor can be caused by capacitor-intense loads, a lightly loaded synchronous motor or an induction motor that is being driven by its load. \n" +
                "3.\tLagging power factor is caused mainly by induction motors. \n" +
                "4.\tUnity power factor can be found in loads dominated by electronic devices or resistance loads such as lights and heaters. \n" +
                "5.\tAverage industrial loads include many motors, so the recognized standard is 0.8 lagging power factor. Leading power factor is practically unattainable with today’s loads.\n");
        this.addQuestion(q36);
        Question q37 = new Question(36, "It is necessary during maintenance of the electrical installations.", "Operation of Generators", "Saftey Precautions", "Resistance", "Rain Check", "safety precautions", "It is the ship owner and his staff’s responsibility to maintain the vessel and its electrical equipment in compliance with the requirements of the Classification Society throughout the ship’s lifetime.\n" +
                "You should think safety at all times, and develop a safety conscious attitude. This may well save your life and the lives of others. Most accident occurs due to a momentary loss of concentration or attempts to short-circuit standard safety procedures. DO NOT let this happen to YOU.\n");
        this.addQuestion(q37);
        Question q38 = new Question(37, "Caused by the flow of the current through you’re your body.", "Operation of Generators", "Electric Shock", "Thermal Shock", "None", "Electric shock", "This is often from hand to hand or from hand to foot. A shock current as low as 15 mA ac or dc may be fatal. Obviously the size of the shock current is related to the applied voltage and your body’s resistance.");
        this.addQuestion(q38);
        Question q39 = new Question(38, "This method is to fix typical failures on the generators.", "Operation of Generators", "resting", "troubleshooting", "inspect", "troubleshooting", "Typical failures on the generator may be one or more of the following:\n" +
                "-\tIncorrect voltage when the generator runs at idle:\n" +
                "Probable cause: Failure within the voltage regulator or excitation diodes. Loose connections may also be the cause.\n" +
                "-\tIncorrect voltage at increasing load:\n" +
                "Probable cause: The cause of failure can be found in the current dependent part of the voltage regulation equipment. This is detected by a rapid decrease of voltage at increased load and unequal reactive load sharing.\n" +
                "The fault may also be found in the excitation diodes, if the voltage drop occurs at high load. This is because the voltage regulator is able to compensate for voltage drop at a low load. Since the range of voltage regulation is limited, it will not be able to compensate for the voltage drop at higher loads, if for example one diode is broken.\n" +
                "Faulty windings can be found by resistance measurement of the windings and eventually against earth.\n" +
                "If an isolation resistance test is to be carried out on the generator, remember to disconnect the AVR (automatic voltage control (electronic unit), instrument connections and heater supplies.\n" +
                "Worn bearings are normally due to normal wear and tear, and damage caused by vibration. Noise and an increase in the temperature of the bearings are signs of worn bearings.  \n");
        this.addQuestion(q39);
        Question q40 = new Question(39, "Typical dry full contact body resistance is about", "Operation of Generators", "7000 ohm at 25V falling to 2000 ohm at 250V", "5000 ohm at 25V falling to 1000 ohm at 250V", "5000 ohm at 25V falling to 2000 ohm at 250V", "5000 ohm at 25V falling to 2000 ohm at 250V", "The amount of your body resistance also depends on other factors such as your state of health, the degree of contact with live wires and the perspiration or dampness on your skin.");
        this.addQuestion(q40);

        /************************************************************* Aux Boiler ********************************************************************/

        Question q41 = new Question(40, "It is also known as Steam Generator that is used to create a steam by applyting heat energy to water.", "Aux Boiler", "Boiler", "Engine", "Fresh Water Generator", "Boiler", "http://www.ttboilers.dk/steamgenerator_steamboiler.htm");
        this.addQuestion(q41);
        Question q42 = new Question(41, "One of the working principle of dual pressure boiler is \"water is heated by oil burners in the combustion chamber", "Aux Boiler", "FALSE", "TRUE", "Maybe", "TRUE", "The working principle of the dual pressure boiler:\n" +
                "•\tWater is heated by the oil burners in the combustion chamber\n" +
                "•\tThe steam from the primary system is fed to the heat exchanger in the secondary system\n");
        this.addQuestion(q42);
        Question q43 = new Question(42, "This is part of Boiler plant where in the steam is cooled in condenser and recycled.", "Aux Boiler", "Turbine", "Condenser", "Steam", "Turbine", "http://www.ttboilers.dk/steamgenerator_steamboiler.htm");
        this.addQuestion(q43);
        Question q44 = new Question(43, "It is used to pump feedwater into a steam boiler.", "Aux Boiler", "Centrifugal Pump", "Feed Water Pump", "Pump", "Feed Water Pump", "https://www.youtube.com/watch?v=0UFRs4awSCY");
        this.addQuestion(q44);
        Question q45 = new Question(44, "A large capacity condenser may have up to ___ tubes.", "Aux Boiler", "6000", "5000", "4000", "6000", "The condenser is of the seawater cooled tube and shell type- A large capacity condenser may have up to 6000 tubes. The vacuum in the condenser is normally obtained by using one or more steam driven ejectors.");
        this.addQuestion(q45);
        Question q46 = new Question(45, "It is important that we always have a sufficient flow of steam through the super heater when we are firing the boiler to reach the required 2000 C temperature", "Aux Boiler", "TRUE", "FALSE", "MAYBE", "TRUE", "TRUE");
        this.addQuestion(q46);
        Question q47 = new Question(46, "The steam is heated above boiling temperature as it is passing the super heater in the ________.", "Aux Boiler", "Steam", "Furnace", "Drum", "Furnace", "This steam is heated above \"boiling temperature\" as it is passing the super heater in the furnace-");
        this.addQuestion(q47);
        Question q48 = new Question(47, "In the upper drum the steam will leave the water as saturated steam with a water content of approximately:", "Aux Boiler", "2", "0.5", "0.25", "0.25", "In the upper drum the steam will leave the water as saturated steam with a water content of approximately 0.25\n" +
                "Primary steam is entering the evaporating coil in the secondary steam drum and is condensed as the energy is transferred to the secondary steam system\n");
        this.addQuestion(q48);
        Question q49 = new Question(48, "What happens when the density of water is thirty times the density of steam?", "Aux Boiler", "The water in the risers is heated", "Circulating inside the pipes that are arranged as walls", "The mixture of steam and water will flow to the top drum", "The mixture of steam and water will flow to the top drum", "As the density of water is thirty times the density of steam, the mixture of steam and water will flow to the top drum\n" +
                "The heavier water in the top drum will flow back to the lower drum through the down comers outside the furnace walls\n");
        this.addQuestion(q49);
        Question q50 = new Question(49, "This is a complicated construction of steel tubes, pipes and drums", "Aux Boiler", "Boiler", "Pump", "Furnace", "Boiler", "The boiler is a complicated construction of steel tubes, pipes and drums- The primary boiler of the \"D.type\" has an upper and a lower drum connected together with hundreds of tubes and pipes.\n" +
                "The upper drum is the steam/water drum and the lower one the water drum\n");
        this.addQuestion(q50);

    }

    private void addDictionary() {

        Dictionary q1 = new Dictionary(0, "Abaft", "Toward the rear (stern) of the boat. Behind.");
        this.addDictionary(q1);
        Dictionary q2 = new Dictionary(1, "Abeam", "At right angles to the keel of the boat, but not on the boat.");
        this.addDictionary(q2);
        Dictionary q3 = new Dictionary(2, "Aboard", "On or within the boat.");
        this.addDictionary(q3);
        Dictionary q4 = new Dictionary(3, "Above Deck", "On the deck (not over it - see ALOFT)");
        this.addDictionary(q4);
        Dictionary q5 = new Dictionary(4, "Abreast", "Side by side; by the side of.");
        this.addDictionary(q5);
        Dictionary q6 = new Dictionary(5, "Adrift", "Loose, not on moorings or towline.");
        this.addDictionary(q6);
        Dictionary q7 = new Dictionary(6, "Aft", "Toward the stern of the boat.");
        this.addDictionary(q7);
        Dictionary q8 = new Dictionary(7, "Aground", "Touching or fast to the bottom.");
        this.addDictionary(q8);
        Dictionary q9 = new Dictionary(8, "Ahead", "In a forward direction.");
        this.addDictionary(q9);
        Dictionary q10 = new Dictionary(9, "Aids To Navigation", "Artificial objects to supplement natural landmarks indicating safe and unsafe waters.");
        this.addDictionary(q10);
        Dictionary q11 = new Dictionary(10, "Alee", "Away from the direction of the wind. Opposite of windward.");
        this.addDictionary(q11);
        Dictionary q12 = new Dictionary(11, "Aloft", "Above the deck of the boat.");
        this.addDictionary(q12);
        Dictionary q13 = new Dictionary(12, "Amidships", "In or toward the center of the boat.");
        this.addDictionary(q13);
        Dictionary q14 = new Dictionary(13, "Anchor", "A heavy metal device, fastened to a chain or line, to hold a vessel in position, partly because of its weight, but chiefly because the designed shape digs into the bottom.");
        this.addDictionary(q14);
        Dictionary q15 = new Dictionary(14, "Anchorage", "A place suitable for anchoring in relation to the wind, seas and bottom.");
        this.addDictionary(q15);
        Dictionary q16 = new Dictionary(15, "Astern", "In back of the boat, opposite of ahead.");
        this.addDictionary(q16);
        Dictionary q17 = new Dictionary(16, "Athwartships", "At right angles to the centerline of the boat; rowboat seats are generally athwart ships.");
        this.addDictionary(q17);
        Dictionary q18 = new Dictionary(17, "Aweigh", "The position of anchor as it is raised clear of the bottom.");
        this.addDictionary(q18);
        Dictionary q19 = new Dictionary(18, "Batten Down", "Secure hatches and loose objects both within the hull and on deck.");
        this.addDictionary(q19);
        Dictionary q20 = new Dictionary(19, "Beacon", "A lighted or unlighted fixed aid to navigation attached directly to the earth's surface. (Lights and daybeacons both constitute \"beacons.\")");
        this.addDictionary(q20);
        Dictionary q21 = new Dictionary(20, "Beam", "The greatest width of the boat.");
        this.addDictionary(q21);
        Dictionary q22 = new Dictionary(21, "Bearing", "The direction of an object expressed either as a true bearing as shown on the chart, or as a bearing relative to the heading of the boat.");
        this.addDictionary(q22);
        Dictionary q23 = new Dictionary(22, "Below", "Beneath the deck.");
        this.addDictionary(q23);
        Dictionary q24 = new Dictionary(23, "Bilge", "The interior of the hull below");
        this.addDictionary(q24);
        Dictionary q25 = new Dictionary(24, "Boat", "A fairly indefinite term. A waterborne vehicle smaller than a ship. One definition is a small craft carried aboard a ship.");
        this.addDictionary(q25);
        Dictionary q26 = new Dictionary(25, "Bow", "The forward part of a boat.");
        this.addDictionary(q26);
        Dictionary q27 = new Dictionary(26, "Bow Line", "A docking line leading from the bow.");
        this.addDictionary(q27);
        Dictionary q28 = new Dictionary(27, "Buoy", "An anchored float used for marking a position on the water or a hazard or a shoal and for mooring.");
        this.addDictionary(q28);
        Dictionary q29 = new Dictionary(28, "Cabin", "A compartment for passengers or crew.");
        this.addDictionary(q29);
        Dictionary q30 = new Dictionary(29, "Capsize", "To turn over.");
        this.addDictionary(q30);
        Dictionary q31 = new Dictionary(30, "Cast Off", "To let go.");
        this.addDictionary(q31);
        Dictionary q32 = new Dictionary(31, "Catamaran", "A twin-hulled boat, with hulls side by side.");
        this.addDictionary(q32);
        Dictionary q33 = new Dictionary(32, "Course", "The direction in which a boat is steered.");
        this.addDictionary(q33);
        Dictionary q34 = new Dictionary(33, "Cuddy", "A small shelter cabin in a boat.");
        this.addDictionary(q34);
        Dictionary q35 = new Dictionary(34, "Current", "The horizontal movement of water.");
        this.addDictionary(q35);
        Dictionary q36 = new Dictionary(35, "Daybeacon", "A fixed navigation aid structure used in shallow waters upon which is placed one or more daymarks.");
        this.addDictionary(q36);
        Dictionary q37 = new Dictionary(36, "Daymark", "A signboard attached to a daybeacon to convey navigational information presenting one of several standard shapes (square, triangle, rectangle) and colors (red, green, orange, yellow, or black). Daymarks usually have reflective material indicating the shape, but may also be lighted.");
        this.addDictionary(q37);
        Dictionary q38 = new Dictionary(37, "Deck", "A permanent covering over a compartment, hull or any part thereof.");
        this.addDictionary(q38);
        Dictionary q39 = new Dictionary(38, "Dolphin", "A group of piles driven close together and bound with wire cables into a single structure.");
        this.addDictionary(q39);
        Dictionary q40 = new Dictionary(39, "Draft", "The depth of water a boat draws.");
        this.addDictionary(q40);
        Dictionary q41 = new Dictionary(40, "Ease", "To slacken or relieve tension on a line.");
        this.addDictionary(q41);
        Dictionary q42 = new Dictionary(41, "Ebb Tide", "A receding tide.");
        this.addDictionary(q42);
        Dictionary q43 = new Dictionary(42, "Even Keel", "When a boat is floating on its designed waterline, it is said to be floating on an even keel.");
        this.addDictionary(q43);
        Dictionary q44 = new Dictionary(43, "Eye Of The Wind", "The direction from which the wind is blowing.");
        this.addDictionary(q44);
        Dictionary q45 = new Dictionary(44, "Eye Splice", "A permanent loop spliced in the end of a line.");
        this.addDictionary(q45);
        Dictionary q46 = new Dictionary(45, "Fast", "Said of an object that is secured to another.");
        this.addDictionary(q46);
        Dictionary q47 = new Dictionary(46, "Fathom", "Six feet.");
        this.addDictionary(q47);
        Dictionary q48 = new Dictionary(47, "Fender", "A cushion, placed between boats, or between a boat and a pier, to prevent damage.");
        this.addDictionary(q48);
        Dictionary q49 = new Dictionary(48, "Figure Eight Knot", "A knot in the form of a figure eight, placed in the end of a line to prevent the line from passing through a grommet or a block.");
        this.addDictionary(q49);
        Dictionary q50 = new Dictionary(49, "Flame Arrester", "A safety device, such as a metal mesh protector, to prevent an exhaust backfire from causing an explosion; operates by absorbing heat.");
        this.addDictionary(q50);
        Dictionary q51 = new Dictionary(50, "Flare", "The outward curve of a vessel's sides near the bow. A distress signal.");
        this.addDictionary(q51);
        Dictionary q52 = new Dictionary(51, "Flood", "A incoming current.");
        this.addDictionary(q52);
        Dictionary q53 = new Dictionary(52, "Forepeak", "A compartment in the bow of a small boat.");
        this.addDictionary(q53);
        Dictionary q54 = new Dictionary(53, "Forward", "Toward the bow of the boat.");
        this.addDictionary(q54);
        Dictionary q55 = new Dictionary(54, "Fouled", "Any piece of equipment that is jammed or entangled, or dirtied.");
        this.addDictionary(q55);
        Dictionary q56 = new Dictionary(55, "Founder", "when a vessel fills with water and sinks.");
        this.addDictionary(q56);
        Dictionary q57 = new Dictionary(56, "Freeboard", "The minimum vertical distance from the surface of the water to the gunwale.");
        this.addDictionary(q57);
        Dictionary q58 = new Dictionary(57, "Gaff", "A spar to support the head of a gaff sail.");
        this.addDictionary(q58);
        Dictionary q59 = new Dictionary(58, "Galley", "The kitchen area of a boat.");
        this.addDictionary(q59);
        Dictionary q60 = new Dictionary(59, "Gangplank", "A moveable bridge used in boarding or leaving a ship at a pier.");
        this.addDictionary(q60);
        Dictionary q61 = new Dictionary(60, "Ground Tackle", "A collective term for the anchor and its associated gear.");
        this.addDictionary(q61);
        Dictionary q62 = new Dictionary(61, "Gunwale", "The upper edge of a boat's sides (also gunnel).");
        this.addDictionary(q62);
        Dictionary q63 = new Dictionary(62, "Harbor", "A safe anchorage, protected from most storms; may be natural or man-made, with breakwaters and jetties; a place for docking and loading.");
        this.addDictionary(q63);
        Dictionary q64 = new Dictionary(63, "Hard Chine", "An abrupt intersection between the hull side and the hull bottom of a boat so constructed.");
        this.addDictionary(q64);
        Dictionary q65 = new Dictionary(64, "Hatch", "An opening in a boat's deck fitted with a watertight cover.");
        this.addDictionary(q65);
        Dictionary q66 = new Dictionary(65, "Head", "A marine toilet. Also the upper corner of a triangular sail.");
        this.addDictionary(q66);
        Dictionary q67 = new Dictionary(66, "Hull Speed", "The maximum practical speed of a displacement hull.  To calculate, take the square root of the LWL (waterline hull length) and multiply by 1.34.");
        this.addDictionary(q67);
        Dictionary q68 = new Dictionary(67, "Hypothermia", "A life-threatening condition in which the body's warming mechanisms fail to maintain normal body temperature and the entire body cools.");
        this.addDictionary(q68);
        Dictionary q69 = new Dictionary(68, "Inboard", "toward the center of a vessel; inside; a motor fitted inside a boat.");
        this.addDictionary(q69);
        Dictionary q70 = new Dictionary(69, "Intracoastal Waterway", "ICW: bays, rivers, and canals along the coasts (such as the Atlantic and Gulf of Mexico coasts), connected so that vessels may travel without going into the sea.");
        this.addDictionary(q70);
        Dictionary q71 = new Dictionary(70, "Jacobs Ladder", "A rope ladder, lowered from the deck, as when pilots or passengers come aboard.");
        this.addDictionary(q71);
        Dictionary q72 = new Dictionary(71, "Jetty", "A structure, usually masonry, projecting out from the shore; a jetty may protect a harbor entrance.");
        this.addDictionary(q72);
        Dictionary q73 = new Dictionary(72, "Kedge", "To use an anchor to move a boat by hauling on the anchor rode; a basic anchor type.");
        this.addDictionary(q73);
        Dictionary q74 = new Dictionary(73, "Keel", "The centerline of a boat running fore and aft; the backbone of a vessel.");
        this.addDictionary(q74);
        Dictionary q75 = new Dictionary(74, "Ketch", "A two-masted sailboat with the smaller after mast stepped ahead of the rudder post.");
        this.addDictionary(q75);
        Dictionary q76 = new Dictionary(75, "Knot", "A measure of speed equal to one nautical mile (6076 feet) per hour. To convert knots to statute mph, multiply by 1.14.");
        this.addDictionary(q76);
        Dictionary q77 = new Dictionary(76, "Latitude", "distance north or south of the equator measured and expressed in degrees.");
        this.addDictionary(q77);
        Dictionary q78 = new Dictionary(77, "Lazarette", "A storage space in a boat's stern area.");
        this.addDictionary(q78);
        Dictionary q79 = new Dictionary(78, "Leeway", "The sideways movement of the boat caused by either wind or current.");
        this.addDictionary(q79);
        Dictionary q80 = new Dictionary(79, "Longitude", "The distance in degrees east or west of the meridian at Greenwich, England.");
        this.addDictionary(q80);
        Dictionary q81 = new Dictionary(80, "Lubber's Line", "A mark or permanent line on a compass indicating the direction forward parallel to the keel when properly installed.");
        this.addDictionary(q81);
        Dictionary q82 = new Dictionary(81, "Marlinspike", "A tool for opening the strands of a rope while splicing.");
        this.addDictionary(q82);
        Dictionary q83 = new Dictionary(82, "Mast", "A spar set upright to support rigging and sails.");
        this.addDictionary(q83);
        Dictionary q84 = new Dictionary(83, "Mooring", "An arrangement for securing a boat to a mooring buoy or a pier.");
        this.addDictionary(q84);
        Dictionary q85 = new Dictionary(84, "Mooring Buoy", "A buoy secured to a permanent anchor sunk deeply into the bottom.");
        this.addDictionary(q85);
        Dictionary q86 = new Dictionary(85, "Nautical Mile", "One minute of latitude; A measurement used in salt water approximately 6,076 feet - about 1/8 longer than the statute mile of 5,280 feet.");
        this.addDictionary(q86);
        Dictionary q87 = new Dictionary(86, "Navigation", "The art and science of conducting a boat safely from one point to another.");
        this.addDictionary(q87);
        Dictionary q88 = new Dictionary(87, "Navigation Rules", "The regulations governing the movement of vessels in relation to each other, generally called steering and sailing rules.");
        this.addDictionary(q88);
        Dictionary q89 = new Dictionary(88, "Outboard", "Toward or beyond the boat's sides. A detachable engine mounted on a boat's stern.");
        this.addDictionary(q89);
        Dictionary q90 = new Dictionary(89, "Outdrive", "A propulsion system for boats with an inboard engine operating an exterior drive, with drive shaft, gears, and propeller; also called stern-drive and inboard/outboard.");
        this.addDictionary(q90);
        Dictionary q91 = new Dictionary(90, "Overboard", "Over the side or out of the boat.");
        this.addDictionary(q91);
        Dictionary q92 = new Dictionary(91, "Painter", "A line attached to the bow of a boat for use in towing or making fast.");
        this.addDictionary(q92);
        Dictionary q93 = new Dictionary(92, "Passarella", "A retractable brow often installed on yachts.");
        this.addDictionary(q93);
        Dictionary q94 = new Dictionary(93, "Pennant", "The line by which a boat is made fast to a mooring buoy.");
        this.addDictionary(q94);
        Dictionary q95 = new Dictionary(94, "Pier", "A loading platform extending at an angle from the shore.");
        this.addDictionary(q95);
        Dictionary q96 = new Dictionary(95, "Port", "The left side of a boat looking forward. A harbor.");
        this.addDictionary(q96);
        Dictionary q97 = new Dictionary(96, "Privileged Vessel", "A vessel which, according to the applicable Navigation Rule, has right-of-way (this term has been superseded by the term \"stand-on\").");
        this.addDictionary(q97);
        Dictionary q98 = new Dictionary(97, "Propeller", "A rotating device, with two or more blades, that acts as a screw in propelling a vessel.");
        this.addDictionary(q98);
        Dictionary q99 = new Dictionary(98, "Quarter", "The sides of a boat aft of amidships.");
        this.addDictionary(q99);
        Dictionary q100 = new Dictionary(99, "Quartering Sea", "Sea coming on a boat's quarter.");
        this.addDictionary(q100);
        Dictionary q101 = new Dictionary(100, "Reef", "To reduce the sail area.");
        this.addDictionary(q101);
        Dictionary q102 = new Dictionary(101, "Rigging", "The general term for all the lines of a vessel.");
        this.addDictionary(q102);
        Dictionary q103 = new Dictionary(102, "Rode", "The anchor line and/or chain.");
        this.addDictionary(q103);
        Dictionary q104 = new Dictionary(103, "Rope", "In general, cordage as it is purchased at the store. When it comes aboard a vessel and is put to use it becomes line.");
        this.addDictionary(q104);
        Dictionary q105 = new Dictionary(104, "Rudder", "A vertical plate or board for steering a boat.");
        this.addDictionary(q105);
        Dictionary q106 = new Dictionary(105, "Running Lights", "Lights required to be shown on boats underway between sundown and sunup.");
        this.addDictionary(q106);
        Dictionary q107 = new Dictionary(106, "Satellite Navigation", "A form of position finding using radio transmissions from satellites with sophisticated on-board automatic equipment.");
        this.addDictionary(q107);
        Dictionary q108 = new Dictionary(107, "Scope", "Technically, the ratio of length of anchor rode in use to the vertical distance from the bow of the vessel to the bottom of the water. Usually six to seven to one for calm weather and more scope in storm conditions.");
        this.addDictionary(q108);
        Dictionary q109 = new Dictionary(108, "Screw", "A boat's propeller.");
        this.addDictionary(q109);
        Dictionary q110 = new Dictionary(109, "Shoal", "An offshore hazard to navigation at a depth of 16 fathoms (30 meters or 96 feet) or less, composed of unconsolidated material.");
        this.addDictionary(q110);
        Dictionary q111 = new Dictionary(110, "Sloop", "A single masted vessel with working sails (main and jib) set fore and aft.");
        this.addDictionary(q111);
        Dictionary q112 = new Dictionary(111, "Stow", "To put an item in its proper place.");
        this.addDictionary(q112);
        Dictionary q113 = new Dictionary(112, "Swamp", "To fill with water, but not settle to the bottom.");
        this.addDictionary(q113);
        Dictionary q114 = new Dictionary(113, "Tackle", "A combination of blocks and line to increase mechanical advantage.");
        this.addDictionary(q114);
        Dictionary q115 = new Dictionary(114, "Tender", "Refers to a dinghy or a lack of stability.");
        this.addDictionary(q115);
        Dictionary q116 = new Dictionary(115, "True Wind", "The actual direction from which the wind is blowing.");
        this.addDictionary(q116);
        Dictionary q117 = new Dictionary(116, "Turnbuckle", "A threaded, adjustable rigging fitting, used for stays, lifelines and sometimes other rigging.");
        this.addDictionary(q117);
        Dictionary q118 = new Dictionary(117, "Underway", "Vessel in motion, i.e., when not moored, at anchor, or aground.");
        this.addDictionary(q118);
        Dictionary q119 = new Dictionary(118, "V Bottom", "A hull with the bottom section in the shape of a \"V\".");
        this.addDictionary(q119);
        Dictionary q120 = new Dictionary(119, "Variation", "The angular difference between the magnetic meridian and the geographic meridian at a particular location.");
        this.addDictionary(q120);
        Dictionary q121 = new Dictionary(120, "Vhf Radio", "A very high frequency electronic communications and direction finding system.");
        this.addDictionary(q121);
        Dictionary q122 = new Dictionary(121, "Wake", "Moving waves, track or path that a boat leaves behind it, when moving across the waters.");
        this.addDictionary(q122);
        Dictionary q123 = new Dictionary(122, "Waterline", "A line painted on a hull which shows the point to which a boat sinks when it is properly trimmed (see BOOT TOP).");
        this.addDictionary(q123);
        Dictionary q124 = new Dictionary(123, "Wharf", "A man-made structure bonding the edge of a dock and built along or at an angle to the shoreline, used for loading, unloading, or tying up vessels.");
        this.addDictionary(q124);
        Dictionary q125 = new Dictionary(124, "Winch", "A device used to increase hauling power when raising or trimming sails.");
        this.addDictionary(q125);
        Dictionary q126 = new Dictionary(125, "Windward", "Toward the direction from which the wind is coming.");
        this.addDictionary(q126);
        Dictionary q127 = new Dictionary(126, "Yacht", "A pleasure vessel, a pleasure boat; in American usage the idea of size and luxury is conveyed, either sail or power.");
        this.addDictionary(q127);
        Dictionary q128 = new Dictionary(127, "Yaw", "To swing or steer off course, as when running with a quartering sea.");
        this.addDictionary(q128);
        Dictionary q129 = new Dictionary(128, "Yawl", "A two-masted sailboat with the small mizzen mast stepped abaft the rudder post.");
        this.addDictionary(q129);
    }

    private void addQuestionImage() {

        QuestionImage q1 = new QuestionImage(0, "Dual Pressure Boiler", "Condenser", "Feed Water Pump", "Dual Pressure Boiler", "Identification");
        this.addQuestionImage(q1);
        QuestionImage q2 = new QuestionImage(1, "Turbine", "Condenser", "Feed Water Pump", "Turbine", "Identification");
        this.addQuestionImage(q2);
        QuestionImage q3 = new QuestionImage(2, "Turbine", "Condenser", "Feed Water Pump", "Feed Water Pump", "Identification");
        this.addQuestionImage(q3);
        QuestionImage q4 = new QuestionImage(3, "Turbine", "Condenser", "Feed Water Pump", "Condenser", "Identification");
        this.addQuestionImage(q4);
        QuestionImage q5 = new QuestionImage(4, "Water is circulating inside the pipes that are arranged as walls", "This steam is heated above \"boiling temperature\"", "Steam is entering the evaporating coil in the secondary steam drum", "Water is circulating inside the pipes that are arranged as walls", "Identification");
        this.addQuestionImage(q5);
        QuestionImage q6 = new QuestionImage(5, "Water is circulating inside the pipes that are arranged as walls", "This steam is heated above \"boiling temperature\"", "Steam is entering the evaporating coil in the secondary steam drum", "This steam is heated above \"boiling temperature\"", "Identification");
        this.addQuestionImage(q6);
        QuestionImage q7 = new QuestionImage(6, "Water is circulating inside the pipes that are arranged as walls", "This steam is heated above \"boiling temperature\"", "Steam is entering the evaporating coil in the secondary steam drum", "Steam is entering the evaporating coil in the secondary steam drum", "Identification");
        this.addQuestionImage(q7);
    }

    public void addQuestion(Question question) {
        ContentValues values = new ContentValues();

        values.put(KEY_ID, question.getID());
        values.put(KEY_QUESTION, question.getQuestion());
        values.put(KEY_LESSON, question.getLesson());
        values.put(KEY_CHOICEA, question.getChoicea());
        values.put(KEY_CHOICEB, question.getChoiceb());
        values.put(KEY_CHOICEC, question.getChoicec());
        values.put(KEY_ANSWER, question.getAnswer());
        values.put(KEY_ADDINFO, question.getadditionalInfo());

        dbase.insert(TBL_QUESTION, null, values);
    }

    public void addDictionary(Dictionary dictionary) {
        ContentValues values = new ContentValues();

        values.put(KEY_DICID, dictionary.getID());
        values.put(KEY_WORD, dictionary.getWord());
        values.put(KEY_DESC, dictionary.getDescription());

        dbase.insert(TBL_DICTIONARY, null, values);
    }

    public void addQuestionImage(QuestionImage questionImage) {
        ContentValues values = new ContentValues();

        values.put(KEY_IMG_ID, questionImage.getId());
        values.put(KEY_IMG_CHOICEA, questionImage.getChoicea());
        values.put(KEY_IMG_CHOICEB, questionImage.getChoiceb());
        values.put(KEY_IMG_CHOICEC, questionImage.getChoicec());
        values.put(KEY_IMG_ANSWER, questionImage.getAnswer());
        values.put(KEY_IMG_TYPE, questionImage.getType());

        dbase.insert(TBL_QUIZIMAGE, null, values);
    }

    public long insertSound() {

        ContentValues values = new ContentValues();
        values.put(KEY_SOUND_ID, 1);
        values.put(KEY_SOUND, "On");
        return dbase.insert(TBL_SOUND, null, values);
    }

    public long updateSound(String newSound) {

        ContentValues values = new ContentValues();
        values.put(KEY_SOUND, newSound);

        return dbase.update(TBL_SOUND, values, KEY_SOUND_ID + " = '" + 1 + "'", null);
    }

    public long insertSummary(String question, String answer, String addinfo, String status) {

        ContentValues values = new ContentValues();
        values.put(KEY_SUMMARY_QUESTION, question);
        values.put(KEY_SUMMARY_ANSWER, answer);
        values.put(KEY_SUMMARY_ADDINFO, addinfo);
        values.put(KEY_SUMMARY_STATUS, status);

        return dbase.insert(TBL_SUMMARY, null, values);
    }

    public long insertImageSummary(int id, String answer, String status) {

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_SUMMARY_ID, id);
        values.put(KEY_IMAGE_SUMMARY_ANSWER, answer);
        values.put(KEY_IMAGE_SUMMARY_STATUS, status);

        return dbase.insert(TBL_IMAGE_SUMMARY, null, values);
    }

    public long insertScore(String type, String player, String lesson, int score, String datetaken) {

        ContentValues values = new ContentValues();
        values.put(KEY_GAME_TYPE, type);
        values.put(KEY_PLAYER_NAME, player);
        values.put(KEY_SCORE_LESSON_NAME, lesson);
        values.put(KEY_SCORE, score);
        values.put(KEY_DATE_TAKEN, datetaken);

        return dbase.insert(TBL_SCORE, null, values);
    }

    public void delete() {

        dbase.delete(TBL_SUMMARY, null, null);
    }

    public void deleteImage() {

        dbase.delete(TBL_IMAGE_SUMMARY, null, null);
    }

    public DatabaseHelper open() {
        dbase = this.getWritableDatabase();
        return this;
    }

}
