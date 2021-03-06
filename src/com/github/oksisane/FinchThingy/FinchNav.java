package com.github.oksisane.FinchThingy;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;


public class FinchNav {

	public static void main(String args[]) throws InterruptedException {
		Finch myFinch = null;
		myFinch = new Finch();
		while (!myFinch.isFinchUpsideDown()) {
			myFinch.setWheelVelocities(255, 255);
			boolean[] obs = myFinch.getObstacleSensors();
			if (obs[0] && !obs[1]) {
				myFinch.stopWheels();
				while (obs[0] && !obs[1]) {
					obs = myFinch.getObstacleSensors();
					myFinch.setWheelVelocities(255, -255);
				}

			}
			if (obs[1] && !obs[0]) {
				myFinch.stopWheels();
				while (obs[1] && !obs[0]) {
					obs = myFinch.getObstacleSensors();

					myFinch.setWheelVelocities(
							255, -255,300);
				}

			}
			if (obs[0] && obs[1]) {
				myFinch.stopWheels();
				while (obs[0] && obs[1]) {
					obs = myFinch.getObstacleSensors();

					myFinch.setWheelVelocities(-255, -255,200);
					
					myFinch.setWheelVelocities(255, -255,300);

				}

			}
		}
		myFinch.quit();
	}

}
