package soamanagementscripts;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.naming.Context;
import oracle.soa.management.facade.Component;
import oracle.soa.management.facade.Composite;
import oracle.soa.management.facade.Locator;
import oracle.soa.management.facade.LocatorFactory;
import oracle.soa.management.util.CompositeFilter;

public class ListComposites
{
  public ListComposites()
  {
    super();
  }
  public static void main(String[] args) {
          Locator loc = null;
          try {
              loc = LocatorFactory.createLocator(getConnectionDetails());
              CompositeFilter compositeFilter = new CompositeFilter();
              compositeFilter.setPartition("default");
              //compositeFilter.setRevision("1.0");
              List<Composite> composites = new ArrayList<Composite>();
              composites = loc.getComposites(compositeFilter);
              System.out.println("Number of Composites deployed :" +
                                 composites.size());
              Iterator compositesIterator = composites.iterator();
              System.out.println("-----------------------------------------------------");
              while (compositesIterator.hasNext()) {
                  Composite composite = (Composite)compositesIterator.next();
                  System.out.println(composite.getCompositeDN());
                  System.out.println(composite.getState());
                  System.out.println(composite.getInstanceCount());
                 // composite.getFaultCount();
                  List<Component> components = composite.getComponents();
                  Iterator componentIterator = components.iterator();
                  while (componentIterator.hasNext()) {
                      Component component = (Component)componentIterator.next();
                //      component.
                      System.out.println(component.getDN());
                      System.out.println(component.getName());
                      System.out.println(component.getImplementationType());
                      System.out.println(component.getNumberOfInstances());
                      System.out.println(component.getNumberOfActiveInstances());
                  }
                  System.out.println("-------------------------------------------------");
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      } 
      private static Hashtable getConnectionDetails() {
          Hashtable jndiProps = new Hashtable();
          jndiProps.put(Context.PROVIDER_URL, "t3://xxx:1234/soa-infra");
          jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,
                        "weblogic.jndi.WLInitialContextFactory");
          jndiProps.put(Context.SECURITY_PRINCIPAL, "xxx");
          jndiProps.put(Context.SECURITY_CREDENTIALS, "xxxxx");
          jndiProps.put("dedicated.connection", "true");
          return jndiProps;
      }
}
