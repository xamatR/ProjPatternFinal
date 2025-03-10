package com.example.proj.pathern;

public class Main {
    public static void main(String[] args) {
        // Criar um garçom (Observer)
        Waiter waiter = new Waiter("Carlos");

        // Escolher uma fábrica de pedidos (Abstract Factory)
        OrderFactory orderFactory = new DineInOrderFactory();
        Order order = orderFactory.createOrder(101);
        order.attach(waiter);

        // Utilizar o padrão Command para colocar o pedido
        OrderInvoker invoker = new OrderInvoker();
        OrderCommand placeOrder = new PlaceOrderCommand(order);
        invoker.executeCommand(placeOrder);

        // Mudança de estado do pedido (State) e notificação ao garçom
        order.setState(new PreparingOrderState());
        order.setState(new ReadyOrderState());

        // Criação de um prato com Factory Method
        DishCreator pizzaCreator = new PizzaCreator();
        pizzaCreator.serveDish("Margherita");

        // Decorar o prato com extra queijo (Decorator)
        Dish basicPizza = new BasicPizza("Margherita");
        Dish cheesePizza = new ExtraCheeseDecorator(basicPizza);
        System.out.println("Descrição: " + cheesePizza.getDescription() + " | Preço: R$" + cheesePizza.getPrice());

        // Executar procedimento de preparo usando Template Method
        DishPreparationTemplate pastaPrep = new PastaPreparation();
        pastaPrep.prepareDish();

        // Processar uma reclamação com Chain of Responsibility
        ComplaintHandler chefHandler = new ChefComplaintHandler();
        ComplaintHandler managerHandler = new ManagerComplaintHandler();
        chefHandler.setNext(managerHandler);
        chefHandler.handleComplaint("O prato está muito picante!");

        // Utilizar Strategy para pagamento
        PaymentStrategy payment = new CreditCardPayment("1234-5678-9012-3456");
        payment.pay(cheesePizza.getPrice());

        // Exemplo de comando para cancelar pedido
        OrderCommand cancelOrder = new CancelOrderCommand(order);
        invoker.executeCommand(cancelOrder);
    }
}

