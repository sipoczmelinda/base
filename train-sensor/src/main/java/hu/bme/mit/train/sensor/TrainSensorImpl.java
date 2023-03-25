package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import com.google.common.collect.*;


public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private int speedLimit = 5;
	private Table<String,Integer,Integer> tachograph = TreeBasedTable.create();

	public TrainSensorImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
	}

	@Override
	public Table<String,Integer,Integer> getTachograph(){
		return this.tachograph;
	}

	@Override
	public void addTachographValue(String timeStamp, int joystickPosition, int referenceSpeed){
		tachograph.put(timeStamp, joystickPosition, referenceSpeed);
	}

}
