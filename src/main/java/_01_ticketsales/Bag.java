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

    public Long hold(Ticket ticket) {
        if (this.hasInvitation()) {
            this.setTicket(ticket);
            return 0L;
        } else {
            this.setTicket(ticket);
            this.minusAmount(ticket.fee());
            return ticket.fee();
        }
    }

    private boolean hasInvitation() {
        return this.invitation != null;
    }

    public boolean hasTicket() {
        return this.ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
