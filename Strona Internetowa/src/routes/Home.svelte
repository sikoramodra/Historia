<script>
	import { slide } from "svelte/transition";
	import { onMount } from "svelte";
	import { writable } from "svelte/store";
	import Footer from "../lib/sections/Footer.svelte";
	import Navbar from "../lib/sections/Navbar.svelte";
	import { mainColorBorder, mainColorText } from "../stores/ColorStore.js";
	import { Timeline, TimelineItem, Button } from "flowbite-svelte";
	import { ArrowRightOutline } from "flowbite-svelte-icons";

	//import Scrollbar from 'smooth-scrollbar'

	/* import Attribution from './components/Attribution.svelte'
	import Hero from './containers/Hero.svelte'
	import Divider from './components/Divider.svelte'
	import Feature from './containers/Feature.svelte'
	

	import { initAnimations } from './scripts/animations'
	*/

	mainColorText.set("text-white");
	mainColorBorder.set("border-white");

	let textToAnimate = writable("");
	let index = 0;
	let speed = 70; // Adjust the speed of typing animation here

	// Text to animate
	const text = "Jesteśmy by Pamiętać";

	onMount(() => {
		const type = () => {
			if (index < text.length) {
				const currentChar = text.charAt(index);
				if (currentChar === " ") {
					textToAnimate.update((oldValue) => oldValue + currentChar); // Append space without removing it
				} else {
					textToAnimate.update((oldValue) => oldValue + currentChar);
				}
				index++;
				setTimeout(type, speed);
			}
		};
		type();
		const parallax = document.getElementById("parallax");

		// Parallax Effect for DIV 1
		window.addEventListener("scroll", function () {
			let offset = window.pageYOffset;
			parallax.style.backgroundPositionY = offset * 0.7 + "px";
			// DIV 1 background will move slower than other elements on scroll.
		});
	});

	onMount(() => {
		// Scroll Down Button
		const scrollDownButton = document.getElementById("scroll-down");
		if (scrollDownButton) {
			scrollDownButton.addEventListener("click", () => {
				window.scroll({
					top: window.innerHeight,
					behavior: "smooth",
				});
			});
		}
	});
	// DIV 1 background will move slower than other elements on scroll.
</script>

<html lang="en">
	<head>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700" />
	</head>

	<section id="section">
		<div id="parallax" class="parallax-item">
			<h2 id="unique-heading">{$textToAnimate}</h2>
		</div>
		<div class="parallax-item">
			<div class="text">
				<p>Tutaj umieść swój tekst</p>
			</div>
			<img src="obraz1.jpg" alt="Obraz 1" />
			<img src="obraz2.jpg" alt="Obraz 2" />
		</div>
		<div class="parallax-item">
			<h2>Wzium</h2>
		</div>
		<div class="parallax-item">
			<h2>
				<div class="ogracz">
					<Timeline>
						<TimelineItem title="Application UI code in Tailwind CSS" date="February 2022">
							<p class="mb-4 text-base font-normal text-gray-500 dark:text-gray-400">
								Get access to over 20+ pages including a dashboard layout, charts, kanban board, calendar, and pre-order E-commerce &
								Marketing pages.
							</p>
							<Button color="alternative">Learn more<ArrowRightOutline class="ms-2 w-3 h-3" /></Button>
						</TimelineItem>
						<TimelineItem title="Application UI code in Tailwind CSS" date="March 2022">
							<p class="text-base font-normal text-gray-500 dark:text-gray-400">
								All of the pages and components are first designed in Figma and we keep a parity between the two versions even as we
								update the project.
							</p>
						</TimelineItem>
						<TimelineItem title="Application UI code in Tailwind CSS" date="April 2022">
							<p class="text-base font-normal text-gray-500 dark:text-gray-400">
								Get started with dozens of web components and interactive elements built on top of Tailwind CSS.
							</p>
						</TimelineItem>
						<TimelineItem title="Application UI code in Tailwind CSS" date="April 2022">
							<p class="text-base font-normal text-gray-500 dark:text-gray-400">
								Get started with dozens of web components and interactive elements built on top of Tailwind CSS.
							</p>
						</TimelineItem>
						<TimelineItem title="Application UI code in Tailwind CSS" date="April 2022">
							<p class="text-base font-normal text-gray-500 dark:text-gray-400">
								Get started with dozens of web components and interactive elements built on top of Tailwind CSS.
							</p>
						</TimelineItem>
						<TimelineItem title="Application UI code in Tailwind CSS" date="April 2022">
							<p class="text-base font-normal text-gray-500 dark:text-gray-400">
								Get started with dozens of web components and interactive elements built on top of Tailwind CSS.
							</p>
						</TimelineItem>
					</Timeline>
				</div>
			</h2>
		</div>
	</section>
</html>

<Navbar />

<style>
	* {
		padding: 0;
		margin: 0;
	}

	html {
		scroll-behavior: smooth;
	}

	.parallax-item {
		display: flex;
		align-items: center;
		justify-content: center;
		font-weight: bold;
		font-family: Montserrat, sans-serif;
		width: 100%;
		min-height: 100vh;
	}

	#unique-heading {
		color: whitesmoke;
		font-size: 100px;
		margin-left: 15vh;
		margin-right: 85vh;
		margin-top: 40vh;
		margin-bottom: 60vh;
		display: inline-block;
		position: absolute;
	}

	.parallax-item:first-child {
		background: url("../res/defiladapolski.png") no-repeat center center;
		background-size: cover;
		backdrop-filter: brightness(20%);
		position: relative; /* Ustawienie pozycji względnej, aby umożliwić pozycjonowanie pseudo-elementu */
	}

	.parallax-item:first-child::before {
		content: "";
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: rgba(0, 0, 0, 0.61); /* Przezroczyste tło */
		z-index: -1;
	}

	.parallax-item:nth-child(2) {
		display: flex;
		flex-direction: row-reverse; /* Odwróć kierunek flexboxa, aby zdjęcia znalazły się po prawej stronie */
		align-items: center; /* Wyrównaj elementy w pionie */
		background: #02021b;
	}

	.parallax-item:nth-child(2) .text {
		flex: 1; /* Rozszerz tekst na całą dostępną przestrzeń */
		padding: 20px; /* Dodaj trochę marginesu dla estetyki */
	}

	.parallax-item:nth-child(2) img {
		max-width: 50%; /* Ogranicz szerokość zdjęć do 50% szerokości kontenera */
		float: right; /* Zdjęcia będą wyrównane do prawej strony */
		margin-left: 20px; /* Dodaj odstęp między tekstem a zdjęciami */
	}
	.parallax-item:nth-child(3) {
		background: url("../res/gittest2.gif");
		background-size: cover;
		background-position: center;
		background-attachment: fixed; /* Parallax Effect for DIV 3 */
		min-height: 600px;
	}

	.parallax-item:nth-child(4) {
		background: #00070f;
	}

	@media screen and (max-width: 768px) {
		.parallax-item h2 {
			font-size: 1vh;
		}
	}

	.parallax-item h2 {
		font-size: 3rem;
	}
	.ogracz {
		max-width: 70%; /* Zmiana z 30% na 40% */
		max-height: 100px; /* Zmiana z 30% na 70% */
		overflow-y: auto; /* Dodanie przewijania w pionie */
		border: 2px red; /* Dodanie początkowego bordera */
		transition: border-color 0.3s ease; /* Dodanie płynnego przejścia dla bordera */
		display: block;
		min-height: 20em;
	}
	.ogracz:not(:hover) {
		overflow: hidden;
	}
</style>
