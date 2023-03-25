package hu.bme.mit.train.interfaces;
import com.google.common.collect.*;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	Table<String,Integer,Integer> getTachograph();

	void addTachographValue(String timeStamp, int joystickPosition, int referenceSpeed);

}
