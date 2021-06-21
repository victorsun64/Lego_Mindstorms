/**
 * 
 */
package lego_Mindstorms;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;

public class Lego_Mindstorms {

	private static RegulatedMotor rechts;
	private static RegulatedMotor links;
	private static RegulatedMotor rgabel;
	private static RegulatedMotor lgabel;
	private static EV3UltrasonicSensor sonic;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// crack.com

		rechts = new EV3LargeRegulatedMotor(MotorPort.A);
		links = new EV3LargeRegulatedMotor(MotorPort.B);
		rgabel = new EV3LargeRegulatedMotor(MotorPort.C);
		lgabel = new EV3LargeRegulatedMotor(MotorPort.D);
		sonic = new EV3UltrasonicSensor(SensorPort.S4);
		final SampleProvider sp = sonic.getDistanceMode();
		while(true) {

			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			int distanceValue = (int) sample[0];

			while (distanceValue > 0.3) {
				links.forward();
				rechts.forward();
			}
			;
			while (distanceValue < 0.3) {
				rgabel.backward();
				lgabel.backward();
				links.forward();
				rechts.forward();
			}

		}
		
		
	}

}
