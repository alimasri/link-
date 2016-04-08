REM Show program usage
java -cp link_pp.jar app.cli.Application
REM Run a test case
java -cp link_pp.jar app.cli.Application sncf.ttl velib.ttl classes linking-rule.xml output-pattern.xml output.ttl
pause