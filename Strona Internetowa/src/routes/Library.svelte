<script>
	import Tile from "../lib/layouts/Tile.svelte";
	import Navbar from "../lib/sections/Navbar.svelte";
	import { mainColorText, mainColorBorder } from "../stores/ColorStore.js";
	import { fade } from "svelte/transition";
	import { Card, Button, Toggle } from "flowbite-svelte";
	import Footer from "../lib/sections/Footer.svelte";
	import Akali from "../res/Akali.png";

	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	let hCard = false;
</script>

<div class="bg">
	<div class="as">
		<div class="space-y-4 card-container">
			<Card class="card" img={Akali} href="/" horizontal size="md" reverse={hCard}>
				<h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">Noteworthy technology acquisitions 2021</h5>
				<p class="mb-3 font-normal text-gray-700 dark:text-gray-400 leading-tight">
					Here are the biggest enterprise technology acquisitions of 2021 so far, in reverse chronological order.
				</p>
			</Card>
		</div>
	</div>
</div>
<Navbar />
<Footer />

<style>
	.as {
		background: linear-gradient(red, black);
		min-height: 100vh;
	}
	.bg {
		background: linear-gradient(red, black);
	}
	@media (min-width: 768px) {
		/* Ustawienia dla większych ekranów */
		.card-container {
			display: flex;
			flex-direction: column-reverse;
		}
	}
	.as {
		display: flex;
		align-items: center;
		justify-content: center;
		font-weight: bold;
		font-family: Montserrat, sans-serif;
		width: 100%;
		min-height: 100vh;
	}
	/* .card {
		background-color: red;
	} */
</style>
