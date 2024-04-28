<script>
	import Navbar from "../lib/sections/Navbar.svelte";
	import { mainColorBorder, mainColorText } from "../stores/ColorStore.js";
	import { Link } from "svelte-routing";
  
	mainColorText.set("text-white");
	mainColorBorder.set("border-white");
  </script>
  
  <Navbar/>
  
  <div class="linki">
	  <Link to="/library/jogurt"><h1>Read about yogurt</h1></Link>
	  <Link to="/library/czekolada"><h1>Read about chocolate</h1></Link>
	  <Link to="/library/inny-artykul"><h1>Read about something else</h1></Link>
  </div>
  
  <style>
	.linki {
	  margin-top: 100px;
	}
	h1 {
		cursor:pointer;
	}
  </style>