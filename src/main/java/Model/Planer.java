package Model;
public class Planer {
	private int planId;
	private String destination;
	private String startDate;
	private String endDate;
	private double budget;
	private String description;
	private String expenseDate;
	private String descriptionofExpense;
	private double amount;
	
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getDescriptionofExpense() {
		return descriptionofExpense;
	}
	public void setDescriptionofExpense(String descriptionofExpense) {
		this.descriptionofExpense = descriptionofExpense;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Planer [planId=" + planId + ", destination=" + destination + ", startDate=" + startDate + ", endDate="
				+ endDate + ", budget=" + budget + ", description=" + description + ", expenseDate=" + expenseDate
				+ ", descriptionofExpense=" + descriptionofExpense + ", amount=" + amount + "]";
	}
	
	
	
	
}
