<script>
	import Navbar from "../lib/sections/Navbar.svelte";
	import { mainColorBorder, mainColorText } from "../stores/ColorStore.js";
	
		
	mainColorText.set("text-white");
	mainColorBorder.set("border-white");


</script>
<Navbar/>
