package net.hypernite.projects.FTCUtils.core.drive;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Motor {
    private final double OFFSET;
    private final DcMotor MOTOR;// DcMotor It will interact With
    private Gear GEAR;// Current motor gear

    /**
     * Creates a new Motor Instance
     */
    public Motor(DcMotor motor, double offset) {
        this.MOTOR = motor;
        this.MOTOR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.GEAR = Gear.MED;
        this.OFFSET = offset;
    }

    /**
     * Sets the power of the current motor
     */
    public void setPower(double speed) {
        this.MOTOR.setPower(speed * this.gear() * this.OFFSET);
    }

    /**
     * Returns current speed
     */
    public double speed() { return this.MOTOR.getPower(); }

    /**
     * Returns current gear
     */
    public double gear() {
        return this.GEAR.speed();
    }

    /**
     * Shifts the gear down
     */
    public void shift_down() {
        if(this.GEAR.equals(Gear.FAST)){
            this.GEAR = Gear.MED;
        } else if(this.GEAR.equals(Gear.MED)){
            this.GEAR = Gear.SLOW;
        }
    }

    /**
     * moves the motor by the offset, in regard to last position
     * @param offset offset
     */
    public void move(int offset) {
        this.moveTo(this.getPos() + offset);
    }

    /**
     * Moves the motor to a constant position, in regard to position 0
     * @param number number to move by
     */
    public void moveTo(int number) {
        this.MOTOR.setTargetPosition(number);
    }

    /**
     * Gets the current motor position, where 0 is the origin
     * @return current Motor Position
     */
    public int getPos() {
        return this.MOTOR.getCurrentPosition();
    }

    /**
     * Shifts the gear up
     */
    public void shift_up() {
        if(this.GEAR.equals(Gear.SLOW)){
            this.GEAR = Gear.MED;
        } else if(this.GEAR.equals(Gear.MED)){
            this.GEAR = Gear.FAST;
        }
    }
}