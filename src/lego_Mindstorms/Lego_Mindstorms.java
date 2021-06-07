/**
 * 
 */
package lego_Mindstorms;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3UltrasonicSensor;

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
	
			final int distancethreshold = 10000;
			for (int i = 0; i <= distancethreshold; i++) {

				float[] sample = new float[sp.sampleSize()];
				sp.fetchSample(sample, 0);
				distanceValue = (int) sample[0];
				
				if (distanceValue < 0.1) {
					lgabel.backward();
					rgabel.backward();
				} else  {
					rechts.forward();
					links.forward();
				}

			}
			;

			rechts.close();
			links.close();
			lgabel.close();
			rgabel.close();
			sonic.close();
	}

}
