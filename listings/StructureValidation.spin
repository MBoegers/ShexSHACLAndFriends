ASK {
  $this a ex:NamedObject.
  $this ex:NamedObject.name ?val.
  ?val rdf:type xsd::string.
}
ASK {
  $this a ex:NamedObject.
  $this ex:NamedObject.age ?val.
  ?val rdf:type/rdfs:subClassOf* xsd::Integer.
}