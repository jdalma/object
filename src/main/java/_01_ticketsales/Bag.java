package _01_ticketsales;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(Long amount) {
        this.amount = amount;
        this.invitation = null;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    public boolean hasInvitation() {
        return this.invitation != null;
    }

    public boolean hasTicket() {
        return this.ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
