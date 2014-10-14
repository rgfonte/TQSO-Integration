package tqsorest.main;

import java.util.LinkedList;

public class WaitingRoom {
	// Class Members
	private LinkedList<Client> m_clients;
	
	// Methods
	public WaitingRoom() {
		m_clients = new LinkedList<Client>();
	}

	public LinkedList<Client> get_clients() {
		return m_clients;
	}

	public void set_clients(LinkedList<Client> m_clients) {
		this.m_clients = m_clients;
	}
	
	public boolean clientArrive(Client arrivedClient) {
		arrivedClient.set_isOnWaitingRoom(true);
		return m_clients.add(arrivedClient);
	}
	
	public Client serveClient() {
		Client clientToReturn = m_clients.poll();
		if (clientToReturn != null) {
			clientToReturn.set_isOnWaitingRoom(false);
		}
		return clientToReturn;
	}
	
	public int getClientsNumber() {
		return m_clients.size();
	}
}
