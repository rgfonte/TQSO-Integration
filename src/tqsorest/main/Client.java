package tqsorest.main;

public class Client {
	//Class Members
	private boolean is_on_waiting_room;
	private boolean is_served;
	private boolean has_paid;
	
	// Methods
	public Client() {
		is_on_waiting_room = false;
		is_served = false;
		has_paid = false;
	}
	
	public boolean get_isOnWaitingRoom() {
		return is_on_waiting_room;
	}

	public void set_isOnWaitingRoom(boolean is_on_waiting_room) {
		this.is_on_waiting_room = is_on_waiting_room;
	}

	public boolean get_isServed() {
		return is_served;
	}

	public void set_isServed(boolean is_served) {
		this.is_served = is_served;
	}

	public boolean get_hasPaid() {
		return has_paid;
	}

	public void set_hasPaid(boolean has_paid) {
		this.has_paid = has_paid;
	}
}
