When mvn site is invoked, the report will automatically be included in the Project Reports menu.

The plugin can also generate the report using its standalone goal: mvn surefire-report:report

And you may use multiple names/patterns, separated by commas:

mvn -Dtest=TestSquare,TestCi*le test

NOTE: Use syntax e.g. foo/MyTest.java, **/MyTest.java, MyTest or **/lesson12/**/*.java for test parameter.