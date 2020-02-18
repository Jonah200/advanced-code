/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        // Practice Bot Talons are 11 thru 18, number from Front Left to Rear Right
        // 11   16
        // 12      17
        // 13 - 6  18 - 2
        // 14 - 7  19 - 1
        // 15 - 8   
        public static final int kLeftMotor1Port = 15; //8;   //front
        public static final int kLeftMotor2Port = 14; //7;   //back
        public static final int kRightMotor1Port = 18; //2;  //front
        public static final int kRightMotor2Port = 19; //1;  //back
        public static final double kMaxSpeedPercent = 0.5;  

        
        /*
         * public static final int[] kLeftEncoderPorts = new int[] { 0, 1 }; public
         * static final int[] kRightEncoderPorts = new int[] { 2, 3 }; public static
         * final boolean kLeftEncoderReversed = false; public static final boolean
         * kRightEncoderReversed = true;
         * 
         * public static final int kEncoderCPR = 1024; public static final double
         * kWheelDiameterInches = 6; public static final double kEncoderDistancePerPulse
         * = // Assumes the encoders are directly mounted on the wheel shafts
         * (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
         * 
         * public static final boolean kGyroReversed = false;
         * 
         * public static final double kStabilizationP = 1; public static final double
         * kStabilizationI = 0.5; public static final double kStabilizationD = 0;
         * 
         * public static final double kTurnP = 1; public static final double kTurnI = 0;
         * public static final double kTurnD = 0;
         * 
         * public static final double kMaxTurnRateDegPerS = 100; public static final
         * double kMaxTurnAccelerationDegPerSSquared = 300;
         * 
         * public static final double kTurnToleranceDeg = 5; public static final double
         * kTurnRateToleranceDegPerS = 10; // degrees per second
         */
    }

    public static final class IntakeConstants {
        public static final int kLowerIntakeMotorPort = 13; //6;  //left
        public static final int kUpperIntakeMotorPort = 17; //5;  //right
        public static final double kMaxSpeedPercent = .55;  
    }

    public static final class IndexConstants {
        public static final int kRightIndexerMotorPort = 16; //4;  
        public static final int kLeftIndexerMotorPort = 11; //9;  
        public static final double kRightSpeedPercent = 0.6;
        public static final double kLeftSpeedPercent = 0.4;   
    }

    public static final class LoaderConstants {
        public static final double kMaxSpeedPercent = 0.25;
        public static final int kLoader = 12;  
    }

   public static final class ShooterConstants {
        public static final int kRightShooter = 1; 
        public static final int kLeftShooter = 2;
        public static final double kMaxSpeedPercent = 1; 
        
        public static final double kP = .00008;  
        public static final double kI = 0.0;
        public static final double kD = 0;
        public static final double Kff = 0;

        public static final int[] kEncoderPorts = new int[]{4, 5};
        public static final boolean kEncoderReversed = false;
        public static final int kEncoderCPR = 4096;
        
        // Distance units will be rotations
        public static final double kEncoderDistancePerPulse = 1.0 / (double) kEncoderCPR;
        
        public static final double kShooterFreeRPS = 5760;
        public static final double kShooterTargetRPS = 3000;
        public static final double kShooterToleranceRPS = 10;

        //todo
        // On a real robot the feedforward constants should be empirically determined; these are
        // reasonable guesses.
        public static final double kSVolts = 0.16; // started at 0.05, 0.07 was 4950, 0.1 4965, 0.2 5010
        public static final double kVVoltSecondsPerRotation = 12.0 / kShooterFreeRPS;  // Should have value 12V at free speed...
        public static final double kFeederSpeed = 0.5;

    }

    public static final class BeamBrakeConstants {
        public static final int RecieverBottom = 1;
        public static final int TransmitterBottom = 0;
        public static final int RecieverTop = 2;
        public static final int TransmitterTop = 3;
        public static final int RecieverShooter = 6;
        public static final int TransmitterShooter = 7;
    }

    public static final class OIConstants {
        // Main Joystick USB Port
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        public final static int leftYAxis = 1;      // speed 
        public final static int leftXAxis = 0;      //
        public final static int rightYAxis = 5;     //
        public final static int rightXAxis = 4;     // turn
        public final static int bButton = 2;        // shooter
        public final static int yButton = 4;        // reverse indexer
        public final static int xButton = 3;        // forward indexer
        public final static int aButton = 1;        // 
        public final static int leftBumper = 5;     // reverse intake
        public final static int rightBumper = 6;    // forward intake
        public final static int startButton = 8;    //
        public final static int backButton = 7;     //
        public final static int leftButton = 9;     //
        public final static int rightButton = 10;   //



    }

}
