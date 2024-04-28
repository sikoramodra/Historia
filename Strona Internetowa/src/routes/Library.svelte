<script>
	import Navbar from "../lib/sections/Navbar.svelte";

	import { Link } from "svelte-routing";
  
	
  </script>
  
  <Navbar/>
  <html lang="en">
  <body>
  <div class="linki grid-container">
	  <Link to="/library/jogurt"><article class="grid-item"><h1>Read about yogurt</h1></article></Link>
	  <Link to="/library/czekolada"><article class="grid-item"><h1>Read about chocolate</h1></article></Link>
	  <Link to="/library/inny-artykul"><article class="grid-item"><h1>Read about something else</h1></article></Link>
  </div>
  </body></html>
  <style>

	body {
		background-color: orange;
		width:100%;
		min-height: 100%;
	}
	.linki {
	  margin-top: 100px;
	  width:100%;
	  height:100%;
	}
	h1 {
		cursor:pointer;
	}
	html {
		position:absolute;
		min-height: 100%;
		min-width: 100%;
		background:linear-gradient(to bottom,rgb(2 6 23),rgb(30 41 59));
	}
	.grid-container {
  display: grid;
  gap: 5px 5px;
  grid-template-columns: auto auto auto;
  
  padding: 10px;
}
.grid-item {
  background-color: rgba(255, 255, 255, 0.8);
  border: 1px solid rgba(0, 0, 0, 0.8);
  padding: 20px;
  font-size: 30px;
  text-align: center;
}
  </style>