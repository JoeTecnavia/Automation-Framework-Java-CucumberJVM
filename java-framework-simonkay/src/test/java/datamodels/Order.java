package datamodels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;

public class Order extends BaseModel {
	private static final Logger LOG = LogManager.getLogger(Order.class);

	private String orderName;
	private String orderAddress;
	private String orderEmail;
	private String orderPaymentType;

	public Order(String order_paymentType) {
		this.orderName = getFaker().name().fullName();
		this.orderAddress = getFaker().address().streetAddress();
		this.orderEmail = getFaker().internet().emailAddress();
		this.orderPaymentType = order_paymentType;
		LOG.info("Instantiating order: " + this.toString());
	}

	public String getOrderName() {
		return this.orderName;
	}

	public String getOrderAddress() {
		return this.orderAddress;
	}

	public String getOrderEmail() {
		return this.orderEmail;
	}

	public String getOrderPaymentType() {
		return this.orderPaymentType;
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderAddress="
				+ orderAddress + ", orderEmail=" + orderEmail
				+ ", orderPaymentType=" + orderPaymentType + "]";
	}

}
