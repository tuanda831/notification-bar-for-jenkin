import * as React from "react";
import { createRoot } from 'react-dom/client';

import BarComponent from "./bar-component";

window.addEventListener('DOMContentLoaded', function () {
  // Create a new div element
  var container = document.createElement("div");

  const root = createRoot(container!);
  root.render(<BarComponent />);
  
  // notificationBar.textContent = "Message from Nabserv: Charlie got the bang, no cap";
  // notificationBar.setAttribute("style", "background: red; padding: 5px; color: white;font-weight: bold;");

  // Get a reference to the title element
  var header = document.getElementById("page-header");

  // Get a reference to the parent element
  var parent = header.parentNode;

  // Insert the new div before the title element
  parent.insertBefore(container, header);
});
