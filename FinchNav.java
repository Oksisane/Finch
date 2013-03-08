import java.awt.Color;
import java.awt.Robot;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import edu.cmu.ri.createlab.video.VideoHelper;
import edu.cmu.ri.createlab.video.VideoPlayer;

public class FinchNav {

	public static void main(String args[]) throws InterruptedException {
		Finch myFinch = null;
		myFinch = new Finch();
		Scanner f = new Scanner(System.in);
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
		//		int rand = (int)Math.random()*2;
				while (obs[0] && obs[1]) {
					obs = myFinch.getObstacleSensors();

					myFinch.setWheelVelocities(-255, -255,200);
					
			//		if (rand ==1)
					myFinch.setWheelVelocities(255, -255,300);
			//		else 

				}

			}
		}
		myFinch.quit();
	}

}
