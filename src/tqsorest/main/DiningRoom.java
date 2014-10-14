package tqsorest.main;

import java.util.ArrayList;

public class DiningRoom {
	// Class Members
	private int m_max_slots;
	private WaitingRoom m_waiting_room;
	private ArrayList<Client> m_clients_in_progress;
	
	// Methods
	public DiningRoom(WaitingRoom waitingRoom) {
		this(50, waitingRoom);
	}
	
	public DiningRoom(int max_slots, WaitingRoom waitingRoom) {
		m_max_slots = max_slots;
		m_waiting_room = waitingRoom;
		m_clients_in_progress = new ArrayList<Client>();
	}

	public int get_maxSlots() {
		return m_max_slots;
	}

	public void set_maxSlots(int m_max_slots) {
		this.m_max_slots = m_max_slots;
	}

	public WaitingRoom get_waitingRoom() {
		return m_waiting_room;
	}

	public void set_waitingRoom(WaitingRoom m_waiting_room) {
		this.m_waiting_room = m_waiting_room;
	}

	public ArrayList<Client> get_clientsInProgress() {
		return m_clients_in_progress;
	}

	public void set_clientsInProgress(ArrayList<Client> m_clients_in_progress) {
		this.m_clients_in_progress = m_clients_in_progress;
	}
	
	public boolean addClient(Client clientToAdd) {
		if ( m_clients_in_progress.size() < m_max_slots ) {
			m_clients_in_progress.add(clientToAdd);
			return true;
		}
		return false;
	}
	
	public boolean removeClient(Client clientToRemove) {
		return m_clients_in_progress.remove(clientToRemove);
	}
	
	public boolean pickAClientFromWaitingRoom() {
		return true;
	}
	
	public boolean endAClientServiceInWaintingRoom(Client clientToEndService) {
		clientToEndService.set_isOnWaitingRoom(false);
		
		return removeClient(clientToEndService);
	}
}
