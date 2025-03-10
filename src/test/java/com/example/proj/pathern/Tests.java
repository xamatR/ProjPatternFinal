package com.example.proj.pathern;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import com.example.proj.pathern.*;

public class Tests {

    // -------------------------------
    // State Pattern Tests
    // -------------------------------
    @Test
    public void testNewOrderStateNext() {
        Order order = new DineInOrder(101);
        order.setState(new NewOrderState());
        String result = order.getState().next(order);
        assertEquals("Transitioned from New to Preparing.", result);
        assertEquals("Preparing", order.getStatus());
    }

    @Test
    public void testNewOrderStatePrevious() {
        Order order = new DineInOrder(102);
        order.setState(new NewOrderState());
        String result = order.getState().previous(order);
        assertEquals("Order is already in New state.", result);
        assertEquals("New", order.getStatus());
    }

    @Test
    public void testPreparingOrderStateNext() {
        Order order = new DineInOrder(103);
        order.setState(new PreparingOrderState());
        String result = order.getState().next(order);
        assertEquals("Transitioned from Preparing to Ready.", result);
        assertEquals("Ready", order.getStatus());
    }

    @Test
    public void testPreparingOrderStatePrevious() {
        Order order = new DineInOrder(104);
        order.setState(new PreparingOrderState());
        String result = order.getState().previous(order);
        assertEquals("Reverted from Preparing to New.", result);
        assertEquals("New", order.getStatus());
    }

    @Test
    public void testReadyOrderStateNext() {
        Order order = new DineInOrder(105);
        order.setState(new ReadyOrderState());
        String result = order.getState().next(order);
        assertEquals("Transitioned from Ready to Served.", result);
        assertEquals("Served", order.getStatus());
    }

    @Test
    public void testReadyOrderStatePrevious() {
        Order order = new DineInOrder(106);
        order.setState(new ReadyOrderState());
        String result = order.getState().previous(order);
        assertEquals("Reverted from Ready to Preparing.", result);
        assertEquals("Preparing", order.getStatus());
    }

    @Test
    public void testServedOrderStateNext() {
        Order order = new DineInOrder(107);
        order.setState(new ServedOrderState());
        String result = order.getState().next(order);
        assertEquals("The order has already been served.", result);
        assertEquals("Served", order.getStatus());
    }

    @Test
    public void testServedOrderStatePrevious() {
        Order order = new DineInOrder(108);
        order.setState(new ServedOrderState());
        String result = order.getState().previous(order);
        assertEquals("Reverted from Served to Ready.", result);
        assertEquals("Ready", order.getStatus());
    }

    @Test
    public void testCancelledOrderStateNext() {
        Order order = new DineInOrder(109);
        order.setState(new CancelledOrderState());
        String result = order.getState().next(order);
        assertEquals("Pedido cancelado, sem próximo estado.", result);
        assertEquals("Cancelled", order.getStatus());
    }

    @Test
    public void testCancelledOrderStatePrevious() {
        Order order = new DineInOrder(110);
        order.setState(new CancelledOrderState());
        String result = order.getState().previous(order);
        assertEquals("Pedido cancelado, sem estado anterior.", result);
        assertEquals("Cancelled", order.getStatus());
    }

    // -------------------------------
    // Abstract Factory Tests
    // -------------------------------
    @Test
    public void testDineInOrderFactory() {
        OrderFactory factory = new DineInOrderFactory();
        Order order = factory.createOrder(201);
        assertNotNull(order);
        assertTrue(order instanceof DineInOrder);
    }

    @Test
    public void testTakeAwayOrderFactory() {
        OrderFactory factory = new TakeAwayOrderFactory();
        Order order = factory.createOrder(202);
        assertNotNull(order);
        assertTrue(order instanceof TakeAwayOrder);
    }

    // -------------------------------
    // Factory Method Tests
    // -------------------------------
    @Test
    public void testPizzaCreationUsingFactoryMethod() {
        DishCreator creator = new PizzaCreator();
        Dish dish = creator.createDish("Hawaiian");
        assertNotNull(dish);
        assertEquals("Pizza Hawaiian", dish.getDescription());
    }

    @Test
    public void testBurgerCreationUsingFactoryMethod() {
        DishCreator creator = new BurgerCreator();
        Dish dish = creator.createDish("Cheeseburger");
        assertNotNull(dish);
        assertEquals("Burger Cheeseburger", dish.getDescription());
    }

    // -------------------------------
    // Decorator Pattern Tests
    // -------------------------------
    @Test
    public void testExtraCheeseDecorator() {
        Dish pizza = new BasicPizza("Margherita");
        Dish decoratedPizza = new ExtraCheeseDecorator(pizza);
        assertEquals("Pizza Margherita with extra cheese", decoratedPizza.getDescription());
        // BasicPizza price: 8.0, extra cheese adds 1.5, total should be 9.5
        assertEquals(9.5, decoratedPizza.getPrice());
    }

    // -------------------------------
    // Strategy Pattern Tests
    // -------------------------------
    @Test
    public void testPaymentStrategyCash() {
        PaymentStrategy cash = new CashPayment();
        String result = cash.pay(15.0);
        assertEquals("Payment of R$15.0 in cash.", result);
    }

    @Test
    public void testPaymentStrategyCard() {
        PaymentStrategy card = new CreditCardPayment("1111-2222-3333-4444");
        String result = card.pay(25.0);
        assertEquals("Payment of R$25.0 with card 1111-2222-3333-4444.", result);
    }

    // -------------------------------
    // Template Method Pattern Tests
    // -------------------------------
    @Test
    public void testTemplateMethodForPastaPreparation() {
        DishPreparationTemplate pastaPrep = new PastaPreparation();
        String steps = pastaPrep.prepareDish();
        assertTrue(steps.contains("Boiling pasta and preparing the sauce."));
        assertTrue(steps.contains("Mixing pasta and sauce."));
        assertTrue(steps.contains("Dish is being plated."));
    }

    // -------------------------------
    // Chain of Responsibility Tests
    // -------------------------------
    @Test
    public void testChainOfResponsibilityChefComplaint() {
        ComplaintHandler chefHandler = new ChefComplaintHandler();
        String result = chefHandler.handleComplaint("This dish is too spicy.");
        assertEquals("Chef: I will adjust the spice level.", result);
    }

    @Test
    public void testChainOfResponsibilityManagerComplaint() {
        ComplaintHandler chefHandler = new ChefComplaintHandler();
        ComplaintHandler managerHandler = new ManagerComplaintHandler();
        chefHandler.setNext(managerHandler);
        String result = chefHandler.handleComplaint("The service is poor.");
        assertEquals("Manager: We will improve the service.", result);
    }

    @Test
    public void testChainOfResponsibilityUnhandledComplaint() {
        ComplaintHandler chefHandler = new ChefComplaintHandler();
        ComplaintHandler managerHandler = new ManagerComplaintHandler();
        chefHandler.setNext(managerHandler);
        String result = chefHandler.handleComplaint("The ambiance is off.");
        assertEquals("Complaint not handled.", result);
    }

    // -------------------------------
    // Command Pattern Tests
    // -------------------------------
    @Test
    public void testPlaceOrderCommand() {
        OrderFactory factory = new DineInOrderFactory();
        Order order = factory.createOrder(301);
        OrderInvoker invoker = new OrderInvoker();
        OrderCommand placeCommand = new PlaceOrderCommand(order);
        String result = invoker.executeCommand(placeCommand);
        assertTrue(result.contains("Executing: Place order 301"));
        assertTrue(result.contains("Order 301 added."));
    }

    @Test
    public void testCancelOrderCommand() {
        OrderFactory factory = new DineInOrderFactory();
        Order order = factory.createOrder(302);
        OrderInvoker invoker = new OrderInvoker();
        OrderCommand cancelCommand = new CancelOrderCommand(order);
        String result = invoker.executeCommand(cancelCommand);
        assertTrue(result.contains("Executing: Cancel order 302."));
        assertTrue(order.getStatus().contains("Cancelled"));
    }
}
