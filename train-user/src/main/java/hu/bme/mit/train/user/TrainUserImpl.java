package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;
import java.lang.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class TrainUserImpl implements TrainUser {
	private TrainController controller;
	private TrainSensor sensor;
	private int joystickPosition;

	public TrainUserImpl(TrainController controller, TrainSensor sensor) {
		this.controller = controller;
		this.sensor = sensor;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		sensor.addTachographValue(timeStamp, joystickPosition, controller.getReferenceSpeed());
	}

	@Override
	public void emergencyBraking(){
		controller.setReferenceSpeed(0);
	}

	@Override
	public void stopEmergencyBraking(){
		controller.setReferenceSpeed(sensor.getSpeedLimit());
	}

}
