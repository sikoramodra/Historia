<script>
	import AddBadges from "./../lib/layouts/People/AddBadges.svelte";
	import AddActivities from "./../lib/layouts/People/AddActivities.svelte";
	import { Link } from "svelte-routing";
	import Logo from "../res/Logo_poziom_ciemne_tło_PNG.png";
	import AddRanks from "../lib/layouts/People/AddRanks.svelte";

	let formData = {
		name: "",
		inscription: "",
		other_names: [],
		code_names: [],
		birth_date: "",
		birth_place: null,
		death_date: "",
		death_place: null,
		grave: null,
		description: "",
		sources: "",
	};

	let otherFormData = {
		ranks: [],
		badges: [],
		activities: [],
	};

	//--- Handling Date Inputs ---

	// --- Birth Inputs ---

	let birthData = {
		day: null,
		maxDay: 31,
		month: null,
		year: null,
		maxYear: new Date().getFullYear(),
		date: "",
	};

	function handleBirthDate(x) {
		if (x === 1) {
			let day = birthData.day !== null ? birthData.day : 1;
			let month = birthData.month !== null ? birthData.month : 1;
			let year = birthData.year !== null ? birthData.year : "2024";

			const maxDaysInMonth = new Date(year, month, 0);

			birthData.maxDay = maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31;
			day = Math.min(day, maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31);
			day = Math.max(day, 1);
			month = Math.min(month, 12);
			month = Math.max(month, 1);
			year = Math.max(year, 1);
			year = Math.min(year, birthData.maxYear);

			birthData.day = day;
			birthData.month = month;
			birthData.year = year;

			birthData.date = `${year.toString().padStart(4, "0")}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;
		} else {
			birthData.day = `${birthData.date[8]}${birthData.date[9]}`;
			birthData.month = `${birthData.date[5]}${birthData.date[6]}`;
			birthData.year = `${birthData.date[0]}${birthData.date[1]}${birthData.date[2]}${birthData.date[3]}`;
		}
		formData.birth_date = birthData.date;
	}

	// --- Death Inputs ---

	let deathData = {
		day: null,
		maxDay: 31,
		month: null,
		year: null,
		maxYear: new Date().getFullYear(),
		date: "",
	};

	function handleDeathDate(x) {
		if (x === 1) {
			let day = deathData.day !== null ? deathData.day : 1;
			let month = deathData.month !== null ? deathData.month : 1;
			let year = deathData.year !== null ? deathData.year : "2024";

			const maxDaysInMonth = new Date(year, month, 0);

			deathData.maxDay = maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31;
			day = Math.min(day, maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31);
			day = Math.max(day, 1);
			month = Math.min(month, 12);
			month = Math.max(month, 1);
			year = Math.max(year, 1);
			year = Math.min(year, deathData.maxYear);

			deathData.day = day;
			deathData.month = month;
			deathData.year = year;

			deathData.date = `${year.toString().padStart(4, "0")}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;
		} else {
			deathData.day = `${deathData.date[8]}${deathData.date[9]}`;
			deathData.month = `${deathData.date[5]}${deathData.date[6]}`;
			deathData.year = `${deathData.date[0]}${deathData.date[1]}${deathData.date[2]}${deathData.date[3]}`;
		}
		console.log(deathData.date);
		formData.death_date = deathData.date;
	}

	// --- --- ---
	// --- Array Inputs Handling ---

	function addInput(key) {
		if (key == "other_names" || key == "code_names") formData[key].push("");
		formData = { ...formData };
	}

	// function handleInputChange(index, event, key, i) {
	// 	if(key == "sub_badges") formData["badges"][i][key][index] = event.target.value;
	// 	else if (key == "badge_name") formData["badges"][i]
	// 	else formData[key][index] = event.target.value;

	// 	// Additional Functionality

	// 	// if (index === formData[key].length - 1 && event.target.value.trim() !== "") {
	// 	// 	addInput(key);
	// 	// } else if (formData[key][index] === "") {
	// 	// 	for (let i = formData[key].length - 1; i > index; i--) {
	// 	// 		removeInput(i, key);
	// 	// 	}
	// 	// }
	// }

	function removeInput(index, key) {
		formData[key].splice(index);
		formData = { ...formData };
	}

	// --- --- ---

	async function handleSubmit() {
		formData.birth_date = formData.birth_date === "" ? null : formData.birth_date;
		formData.death_date = formData.death_date === "" ? null : formData.death_date;
		formData = { ...formData };
		alert(JSON.stringify(formData));
		try {
			const response = await fetch(`${import.meta.env.VITE_DB_URL}people`, {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(formData),
			});

			console.log(response);

			if (!response.ok) {
				throw new Error("Failed to submit form");
			}

			console.log("Form submitted successfully");

			window.location.href = "/search-site";
		} catch (error) {
			console.error("Error submitting form:", error.message);
		}
	}
</script>

<div class="min-h-screen bg-gray-900 flex justify-center flex-col items-center">
	<!-- Navbar -->
	<div class="mb-6 text-2xl flex flex-row justify-between w-full items-center">
		<!-- Go Back -->
		<Link to="/search-site" class="ml-6">
			<svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 24 24">
				<path d="M0 0h24v24H0z" fill="none" />
				<path d="M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z" fill="rgb(156 163 175)" />
			</svg>
		</Link>

		<!-- Logo -->
		<Link to="/" class="font-bold h-full items-center flex justify-left"
			><img src={Logo} alt="Home" class="h-[2.5em] md:h-[2.5em] lg:h-[3em]" /></Link
		>

		<!-- Help -->
		<button id="help" class="mr-6">
			<svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 512 512"
				><path
					fill="rgb(156 163 175)"
					d="M256 512A256 256 0 1 0 256 0a256 256 0 1 0 0 512zM216 336h24V272H216c-13.3 0-24-10.7-24-24s10.7-24 24-24h48c13.3 0 24 10.7 24 24v88h8c13.3 0 24 10.7 24 24s-10.7 24-24 24H216c-13.3 0-24-10.7-24-24s10.7-24 24-24zm40-208a32 32 0 1 1 0 64 32 32 0 1 1 0-64z"
				/></svg
			>
		</button>
	</div>

	<!-- Form -->
	<div class="bg-gradient-to-br from-gray-900 to-gray-700 h-[80vh] w-[80vw] rounded-2xl shadow-2xl border border-gray-400 relative p-1 text-xl shadow-gray-600">
		<form on:submit|preventDefault action="/people" method="POST" class="h-full overflow-auto p-6 grid grid-cols-1 lg:grid-cols-2 gap-4">
			<div id="official-info" class="border border-white p-4 rounded-xl mb-4 shadow-2xl shadow-black flex items-center flex-col justify-evenly">
				<!-- Name -->
				<div class="relative p-8 w-full">
					<label for="name" class="block text-white font-bold mb-2">Imię i Nazwisko*:</label>
					<input
						type="text"
						name="name"
						id="name"
						placeholder="np. Jan Kowalski..."
						class="w-full p-2 border rounded-md"
						bind:value={formData.name}
					/>
				</div>

				<!-- Other Names -->
				<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl w-full">
					{#each formData.other_names as _, index (index)}
						<div class="mb-2">
							<p class="block text-white font-bold mb-2">
								{index === 0 ? "Alternatywne Imię i Nazwisko:" : "Dodatkowe Imię i Nazwisko:"}
							</p>
							<input
								type="text"
								name="other_names"
								id="other_names_{index}"
								placeholder="np. Jan Nowak..."
								class="p-2 border rounded-md w-full"
								bind:value={formData.other_names[index]}
							/>
						</div>
					{/each}
					{#if formData.other_names[formData.other_names.length - 1] !== ""}
						<button type="button" on:click={() => addInput("other_names")} class="text-white font-bold"
							>Dodaj Alternatywne Imię i Nazwisko</button
						>
					{/if}
					{#if formData.other_names[formData.other_names.length - 1] === ""}
						<button type="button" on:click={() => removeInput(formData.other_names.length - 1, "other_names")} class="text-white">
							Usuń
						</button>
					{/if}
				</div>

				<!-- Code Names -->
				<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl w-full">
					{#each formData.code_names as _, index (index)}
						<div class="mb-2">
							<p class="block text-white font-bold mb-2">
								{index === 0 ? "Pseudonim:" : "Dodatkowy Pseudonim:"}
							</p>
							<input
								type="text"
								name="code_names"
								id="code_names_{index}"
								placeholder="np. Jastrząb..."
								class="p-2 border rounded-md w-full"
								bind:value={formData.code_names[index]}
							/>
						</div>
					{/each}
					{#if formData.code_names[formData.code_names.length - 1] !== ""}
						<button type="button" on:click={() => addInput("code_names")} class="text-white font-bold">Dodaj Pseudonim</button>
					{/if}
					{#if formData.code_names[formData.code_names.length - 1] === ""}
						<button type="button" on:click={() => removeInput(formData.code_names.length - 1, "code_names")} class="text-white">
							Usuń
						</button>
					{/if}
				</div>
			</div>

			<div id="date-place-info" class="border border-white shadow-2xl shadow-black p-4 rounded-xl mb-4 flex flex-col">
				<!-- Birth Date/Place -->
				<div class="border border-white p-8 rounded-xl mb-4">
					<!-- Birth Date -->
					<div class="mb-4">
						<div class="relative">
							<label for="birth_date" class="block text-white font-bold mb-2">Data Urodzenia:</label>
							<div class="flex flex-row">
								<input
									type="number"
									name="birth_date"
									id="birth_date_day"
									placeholder="Dzień"
									min="1"
									max={birthData.maxDay}
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={birthData.day}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="number"
									name="birth_date"
									id="birth_date_month"
									placeholder="Miesiąc"
									min="1"
									max="12"
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={birthData.month}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="number"
									name="birth_date"
									id="birth_date_year"
									placeholder="Rok"
									min="1"
									max="10000"
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={birthData.year}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="date"
									name="birth_date"
									id="birth_date"
									class=" sm:w-9 w-full p-2 border rounded-md"
									bind:value={birthData.date}
									on:input={() => handleBirthDate(2)}
								/>
							</div>
						</div>
					</div>

					<!-- Birth Place -->
					<div class="mb-4 relative">
						<label for="birth_place" class="block text-white font-bold mb-2">Miejsce Urodzenia:</label>
						<input
							type="number"
							min="0"
							name="birth_place_id"
							id="birth_place"
							placeholder="np. Warszawa..."
							class="w-full p-2 border rounded-md"
							bind:value={formData.birth_place}
						/>
					</div>
				</div>

				<!-- Death Date/Place -->
				<div class="border border-white p-8 rounded-xl">
					<!-- Death Date -->
					<div class="mb-4">
						<div class="relative">
							<label for="death_date" class="block text-white font-bold mb-2">Data Śmierci:</label>
							<div class="flex flex-row">
								<input
									type="number"
									name="death_date"
									id="death_date_day"
									placeholder="Dzień"
									min="1"
									max={deathData.maxDay}
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={deathData.day}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="number"
									name="death_date"
									id="death_date_month"
									placeholder="Miesiąc"
									min="1"
									max="12"
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={deathData.month}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="number"
									name="death_date"
									id="death_date_year"
									placeholder="Rok"
									min="1"
									max="10000"
									class="p-2 border rounded-md sm:w-[30%] w-0 hidden sm:block mr-2 md:mr-4"
									bind:value={deathData.year}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="date"
									name="death_date"
									id="death_date"
									class="sm:w-9 w-full p-2 border rounded-md"
									bind:value={deathData.date}
									on:input={() => handleDeathDate(2)}
								/>
							</div>
						</div>
					</div>

					<!-- Death Place -->
					<div class="mb-4 relative">
						<label for="death_place" class="block text-white font-bold mb-2">Miejsce Śmierci:</label>
						<input
							type="number"
							min="0"
							name="death_place_id"
							id="death_place"
							placeholder="np. Warszawa..."
							class="w-full p-2 border rounded-md"
							bind:value={formData.death_place}
						/>
					</div>
				</div>
			</div>

			<div id="military-info" class="border border-white p-4 rounded-xl mb-4 shadow-2xl shadow-black">
				<!-- Ranks -->
				<div>
					<p class="text-white font-extrabold text-center mb-4">Stopień Wojskowy:</p>
					<div class="border border-white p-8 rounded-xl mb-4">
						<AddRanks bind:data={otherFormData.ranks} />
					</div>
				</div>

				<!-- Badges -->
				<div>
					<p class="text-white font-extrabold text-center mb-4">Odznaczenia:</p>
					<div class="border border-white p-8 rounded-xl mb-4">
						<AddBadges bind:data={otherFormData.badges} />
					</div>
				</div>

				<!-- Activity -->
				<div>
					<p class="text-white font-extrabold text-center mb-4">Wydarzenia:</p>
					<div class="border border-white p-8 rounded-xl mb-4">
						<AddActivities bind:data={otherFormData.activities} />
					</div>
				</div>
			</div>

			<div id="cemetery-info" class="border border-white p-8 px-12 rounded-xl mb-4 shadow-2xl shadow-black">
				<!-- Cemetery -->
				<div class="mb-4 relative">
					<label for="cemetery" class="block text-white font-bold mb-2">Cmentarz:</label>
					<input type="text" name="cemetery" id="cemetery" placeholder="np. Cmentarz centralny w Szczecinie..." class="w-full p-2 border rounded-md" bind:value={formData.cemetery} />
				</div>

				<!-- Quarter -->
				<div class="mb-4 relative">
					<label for="quarter" class="block text-white font-bold mb-2">Kwatera:</label>
					<input type="text" name="quarter" id="quarter" class="w-full p-2 border rounded-md" placeholder="np. 3C..." bind:value={formData.quarter} />
				</div>

				<!-- Row -->
				<div class="mb-4 relative">
					<label for="row" class="block text-white font-bold mb-2">Rząd:</label>
					<input type="number" name="row" id="row" min="0" placeholder="np. 4..." class="w-full p-2 border rounded-md" bind:value={formData.row} />
				</div>

				<!-- Grave -->
				<div class="mb-4 relative">
					<label for="grave" class="block text-white font-bold mb-2">Grób:</label>
					<input type="number" name="grave_id" id="grave" min="0" class="w-full p-2 border rounded-md" placeholder="np. 11..." bind:value={formData.grave} />
				</div>

				<!-- Burial Place -->
				<div class="mb-4 relative">
					<label for="burial_place" class="block text-white font-bold mb-2">Burial Place:</label>
					<input
						type="number"
						min="0"
						name="burial_place_id"
						id="burial_place"
						placeholder="np. Warszawa..."
						class="w-full p-2 border rounded-md"
						bind:value={formData.burial_place}
					/>
				</div>
			</div>

			<div id="other-info" class="border border-white p-8 px-12 rounded-xl shadow-2xl shadow-black lg:col-span-2">
				<!-- Inscription -->
				<div class="mb-4 relative">
					<label for="inscription" class="block text-white font-bold mb-2">Epitafium:</label>
					<input type="text" name="inscription" id="inscription" placeholder="np. Kochany Ojciec, Brat i Mąż..." class="w-full p-2 border rounded-md" bind:value={formData.inscription} />
				</div>

				<!-- Sources -->
				<div class="col-span-2 mb-4 relative">
					<label for="sources" class="block text-white font-bold mb-2">Źródła:</label>
					<input type="text" name="sources" id="sources" placeholder="np. Wikipedia..." class="w-full p-2 border rounded-md" bind:value={formData.sources} />
				</div>

				<!-- Description -->
				<div class="col-span-2 mb-4 relative">
					<label for="description" class="block text-white font-bold mb-2">Opis:</label>
					<textarea name="description" id="description" rows="5" placeholder="np. Andrzej urodził się we..... po roku w obozie uciekł... po wojnie osiedlił się w Szczecinie..." class="w-full p-2 border rounded-md text-left" bind:value={formData.description} />
				</div>	
			</div>

			<!-- Submit Button -->
			<div class="flex justify-center items-center mt-4 lg:col-span-2">
				<div>
					<button
						type="submit"
						class="active:bg-white active:text-red-600 px-4 py-2 rounded bg-red-600 text-white hover:scale-105 hover:bg-red-500 shadow-2xl shadow-black"
						on:click={handleSubmit}
					>
						<strong>+</strong> <i class="fas fa-user"></i> Dodaj Osobę</button
					>
				</div>
			</div>

			<div class="flex justify-center items-center mt-4 lg:col-span-2">
				<button on:click={() => console.log(formData, otherFormData)} class="active:bg-white active:text-blue-600 px-4 py-2 rounded bg-blue-600 text-white hover:scale-105 hover:bg-blue-500 shadow-2xl shadow-black">Check Data</button>
			</div>
		</form>
	</div>
</div>

<style>
	::-webkit-scrollbar {
		width: 12px;
	}

	::-webkit-scrollbar-track {
		background-color: transparent; /* Change the background color of the track */
		border-radius: 6px;
	}

	::-webkit-scrollbar-thumb {
		background-color: rgb(107 114 128); /* Change the color of the scrollbar thumb */
		border-radius: 6px; /* Add rounded corners to the scrollbar thumb */
	}

	::-webkit-scrollbar-thumb:active {
		background-color: rgb(51 65 85); /* Change the color on hover */
	}
</style>
