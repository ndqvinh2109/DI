# A simple DI's implementation

## Functionality
 - Inject dependency via constructor
 - Support spring bean scopes singleton and prototype
 
## Class desgin

AbstractMapping: a abstract class storing mapping between interface and subclass.
InjectHandling: inject dependency and handling bean scope to configured constructor.
BeanScope: enums class specify bean scope SINGLETON and PROTOTYPE.

## How to use
### Singleton bean
     @Inject(value = BeanScope.SINGLETON)
     public Singleton(FirstService firstService) {
        this.firstService = firstService;
     }
     
     FirstService bean should be injected by DI and only return the same instance everytime.
### Prototype bean
     @Inject(value = BeanScope.PROTOTYPE)
     public Prototype(SecondService secondService) {
         this.secondService = secondService;
     }
     
     FirstService bean should be injected by DI and only return the different instance everytime
     
### Build and run
    + mvn clean install
    + java -jar DIAssigment-1.0-SNAPSHOT.jar
     
## Unit test
### Singleton Bean
    @Test
    public void should_getSameInstanceForSingletonBean() throws Exception {
        injectHandling.injectInstance(Singleton.class);
        Object obj1 = injectHandling.getInstance(FirstService.class);

        injectHandling.injectInstance(Singleton.class);
        Object obj2 = injectHandling.getInstance(FirstService.class);

        Assertions.assertEquals(obj1, obj2);
    }
    
### Prototype Bean

    @Test
    public void should_getDifferentInstanceForPrototypeBean() throws Exception {
        injectHandling.injectInstance(Prototype.class);
        Object obj1 = injectHandling.getInstance(SecondService.class);

        injectHandling.injectInstance(Prototype.class);
        Object obj2 = injectHandling.getInstance(SecondService.class);

        Assertions.assertNotEquals(obj1, obj2);
    }

      
    