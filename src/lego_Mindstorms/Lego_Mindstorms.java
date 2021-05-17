/**
 * 
 */
package lego_Mindstorms;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3UltrasonicSensor;

import org.jfree.util.Rotation;

import lejos.hardware.Button;

public class Lego_Mindstorms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// crack.com
		RegulatedMotor rechts = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor links = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor rgabel = new EV3LargeRegulatedMotor(MotorPort.C);
		RegulatedMotor lgabel = new EV3LargeRegulatedMotor(MotorPort.D);
		EV3UltrasonicSensor sonic = new EV3UltrasonicSensor(SensorPort.S1);
		final SampleProvider sp = sonic.getDistanceMode();
		int distanceValue = 0;

		if (Button.ENTER.isDown()) {
			
	        final int distancethreshold = 1000;
	        for(int i = 0; i <= distancethreshold; i++) {

	        	float [] sample = new float[sp.sampleSize()];
	            sp.fetchSample(sample, 0);
	            distanceValue = (int)sample[0];

				if ( distanceValue < 0.1 ) {lgabel.backward();
				rgabel.backward();}
				
	     
			}
			;
		}
		;
	}

}
