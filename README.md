Proper Naming Convention (Does the variable name describe what it holds, Does the method name specify what it is doing)
Are there typos in the codebase?
Magic Numbers (Should not exist)
Does Classes, Functions, and Methods follow the single responsibility principle.
Is there any redundant or duplicate code? (CPD can be used to detect this)
Is Commented Code present?
Is Code Modular?
Are we overusing Options?
Nested Pattern Matching - Can we convert it into for comprehension?
Do all the data structures have only related data?
Are method arguments simple and appropriate in number?
Do functions in the codebase confirm to the length (more than 50 lines of code)?
Are you using default arguments instead of hardcoded values?
Are we using the tuples judicially or have we seen the probability of creating a case class instead of Tuples?
Is the code too complex to understand?
Do comments exist and describe the intent of the code?
Are all functions commented?
Is any unusual behaviour or edge-case handling described?
Is the use and function of third-party libraries documented?
Are data structures and units of measurement explained?
Is there any incomplete code? If so, should it be removed or flagged with a suitable marker like ‘TODO’?
Are there defined loggers in the code?
Are we capturing information at the appropriate log levels?
Have we done proper logging for debugging purposes if needed?
Are any security checks and logging being done in a proper manner?
Are we logging exceptions correctly for debugging purposes?
Is the code testable? i.e. don’t add too many or hide dependencies, unable to initialize objects, test frameworks can use methods etc.
Do tests exist and are they comprehensive? i.e. has at least your agreed on code coverage.
Do unit tests actually test that the code is performing the intended functionality?
Are arrays checked for ‘out-of-bound’ errors?
Could any test code be replaced with the use of an existing API?
Are we following the proper naming conventions?
Is the code easy to read and understand?
Are we avoiding code smells and anti-patterns?
Does the code comply with the SOLID principles?
Are we following best practices and design patterns?
Is the code well-organized and modular?
Is the code properly commented and documented?
Are we using appropriate data structures and algorithms?
Are we avoiding code duplication and redundancy?
Are we following security best practices?

## What it does?

First, the code defines a class named URLParserUsingExtractor which contains a single method named unapply. This class is responsible for parsing URLs and returning their component parts.

The unapply method takes a single argument urlString which is a string containing the URL to be parsed. It returns an Option containing a tuple of three strings (protocol, domain, and path) if the URL is valid. If the URL is not valid, the method returns None.

Inside the unapply method, the URL string is split into its protocol and domain/path parts using the split method. If the URL does not include a protocol, an IllegalArgumentException is thrown.

The domain and path parts are extracted from the URL and checked for validity. If the domain is empty, another IllegalArgumentException is thrown. If the path contains a newline character, a third IllegalArgumentException is thrown.

If the URL is valid, the method returns an Option containing a tuple of the URL parts (protocol, domain, and path). If the URL is not valid, the method catches the IllegalArgumentException and Throwable exceptions, prints an error message, and returns None.

Next, the code defines an object named URLParserUsingExtractor which extends the App trait. This is the entry point of the program.

Inside the URLParserUsingExtractor object, a new instance of the URLParserUsingExtractor class is created and stored in a private val variable named parser.

A URL string is defined as a private val variable named url.

The url string is then matched against the unapply method of the parser object using pattern matching. If the URL is valid, the protocol, domain, and path parts are extracted and printed to the console. If the URL is not valid, the string "Invalid URL" is printed to the console.
