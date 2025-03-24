package AB1;

import AB1.Interfaces.Encoder;

import java.util.Arrays;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the LinePrinter, configured with a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LinePrinter lp = new LinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                20,
                4
        );
        lp.printString("Hello World");
        lp.flush();

        // TODO: implementation of any developer specific tests (optional)

        ///Braille Encoder testing

        System.out.println();
        lp.printString("Hello");
        lp.flush();
        System.out.println();
        lp.printString("Kevin LIngenhel");
        lp.flush();
        System.out.println();
//        BrailleEncoder b = new BrailleEncoder();
//
//        System.out.println((byte)b.toBinary('b'));
//
//        BrailleFont fanta = new BrailleFont(1,
//                2,
//                'o',
//                '.',
//                new BrailleEncoder());
//
//        for (int i = 'a'; i <= 'z'; i++) {
//            System.out.println(Arrays.deepToString(fanta.getBitmap((char)i)));
//        }
          //  System.out.println(Arrays.deepToString(fanta.getBitmap('b')));


    }
}