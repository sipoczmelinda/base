package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainSensor;

public class TrainUserImpl implements TrainUser {
	private TrainController controller;
	private TrainSensor sensor;
	private int joystickPosition;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
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
	}

	@Override
	public void emergencyBraking(){
		controller.setReferenceSpeed(0);
	}

	@Override
	public void stopEmergencyBraking(){
		controller.setSpeedLimit(sensor.getSpeedLimit());
	}
}
