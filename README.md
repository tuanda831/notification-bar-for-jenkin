# notification-bar

## Introduction

This Plugin will help us pull the data.json and show the notification in the jenkin so that we can communicate with the end user better

## TODO

- [x] setup jenkin simple theme codebase
- [x] setup nodejs and webpack to bundle the React to theme.js
- [x] Implementing the main logic to pull data.json, show the new message and hide the read messages
- [x] Implementing the logic related to the click link event.
- [ ] Testing the impact and put it in the nef-jenkin docker image.
- [ ] Implementing the unit test for Java 
- [ ] Implementing the unit test for ReactJS

## Issues

Report issues and enhancements in the [Jenkins issue tracker](https://issues.jenkins.io/).

## Contributing

### To Test this plugin without install
You could run this plugin without package and install to a jenkin server by run this command:
`./mvnw hpi:run`

### To bundle the reactjs to the theme.js
`npm run build:dev`

### To manualy test the UI
You could access the `http://localhost:8080/jenkins/` for the CSS and JS you don't need to re-build the java source. 
Just simple run `npm run build` and refresh the browser to see the change

### To package the plugin to install in the jenkin (production)

You could following these step:
- Bundle theme.js: `npm run build`
- Clean and package the plugin: `./mvnw clean package -Dmaven.test.skip` 

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

