# Things left to be done

This is a (incomplete, unsorted) list of things which are left to be done:

 - [X] Channel triggers to context thread
 - [ ] Remove connections and components
 - [ ] Force triggers and data
 - [X] Initializer type conversions
 - [ ] Automatic initializer type conversions
 - [X] Multi-type ports & connections
 - [ ] Multi-binding ports -> aggregation function (?)
 - [X] Dynamic ports
 - [ ] Make it easier to work with dynamic ports
 - [ ] Composite components
 - [ ] More explicit exception handling
 - [ ] Monitoring
 - [ ] Persisting flow setups
 - [ ] Real OSGi integration
 - [ ] Revisit initialization order – currently when the start method is called on a component there is no guarantee that
       all connections have been established. However the component has no way to know when the flow was started other
       than the "init" trigger from the flow context. Which is fine, but which is not propagated when the component is
       added into a running flow.
 - [ ] Cache value updates – Right now all values are updated, whether they actually changed or not.
