<script>
	import { Link } from "svelte-routing";

	let formData = {
		name: "",
		other_names: [""],
		code_names: [""],
		birth_date: "",
		birth_place: null,
		death_date: "",
		death_place: null,
		grave: null,
		inscription: "",
		description: "",
		sources: "",
	};

	//--- Handling Date Inputs ---
	// --- Death Inputs ---

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

			console.log("first: " + day);

			birthData.maxDay = maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31;
			day = Math.min(day, maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31);
			day = Math.max(day, 1);
			month = Math.min(month, 12);
			month = Math.max(month, 1);
			year = Math.max(year, 1);
			year = Math.min(year, birthData.maxYear);

			console.log("second: " + day);

			birthData.day = day;
			birthData.month = month;
			birthData.year = year;

			console.log("third: " + day);

			birthData.date = `${year.toString().padStart(4, "0")}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;
		} else {
			birthData.day = `${birthData.date[8]}${birthData.date[9]}`;
			birthData.month = `${birthData.date[5]}${birthData.date[6]}`;
			birthData.year = `${birthData.date[0]}${birthData.date[1]}${birthData.date[2]}${birthData.date[3]}`;
		}
		formData.birth_date = birthData.date;
		console.log(formData.birth_date);
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

			console.log("first: " + day);

			deathData.maxDay = maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31;
			day = Math.min(day, maxDaysInMonth.getDate() ? maxDaysInMonth.getDate() : 31);
			day = Math.max(day, 1);
			month = Math.min(month, 12);
			month = Math.max(month, 1);
			year = Math.max(year, 1);
			year = Math.min(year, deathData.maxYear);

			console.log("second: " + day);

			deathData.day = day;
			deathData.month = month;
			deathData.year = year;

			console.log("third: " + day);

			deathData.date = `${year.toString().padStart(4, "0")}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;
		} else {
			deathData.day = `${deathData.date[8]}${deathData.date[9]}`;
			deathData.month = `${deathData.date[5]}${deathData.date[6]}`;
			deathData.year = `${deathData.date[0]}${deathData.date[1]}${deathData.date[2]}${deathData.date[3]}`;
		}
		formData.birth_date = deathData.date;
		console.log(formData.death_date);
	}

	// --- --- ---

	function addInput(type) {
		const key = type === 1 ? "other_names" : "code_names";
		formData[key] = [...formData[key], ""];
	}

	function handleInputChange(index, event, type) {
		const key = type === 1 ? "other_names" : "code_names";
		formData[key][index] = event.target.value;
		if (event.target.value.trim() === "") {
			for (let i = formData.other_names.length - 1; i > index; i--) {
				removeInput(i, 1);
			}
		}
	}

	function removeInput(index, type) {
		const key = type === 1 ? "other_names" : "code_names";
		formData[key].splice(index, 1);
	}

	async function handleSubmit() {
		try {
			const response = await fetch("http://localhost:5000/people", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(formData),
			});

			if (!response.ok) {
				throw new Error("Failed to submit form");
			}

			console.log("Form submitted successfully");
		} catch (error) {
			console.error("Error submitting form:", error.message);
		}
	}
</script>

<div class="min-h-screen bg-gray-800 flex justify-center flex-col items-center">
	<div class="mb-6 text-2xl">
		<Link to="/" class="font-bold h-full items-center flex justify-left"
			><img
				src="https://raw.githubusercontent.com/sikoramodra/Historia/stronka/Strona%20Internetowa/src/res/Logo%20poziom_ciemne%20tło_PNG.png"
				alt="Home"
				class="h-[2.5em] md:h-[2.5em] lg:h-[3em]"
			/></Link
		>
	</div>
	<div class="bg-gray-600 h-[80vh] w-[80vw] rounded-2xl shadow-xl border border-gray-400 relative p-1">
		<form on:submit|preventDefault={handleSubmit} action="/people" method="POST" class="h-full overflow-auto p-6">
			<div id="official-info" class="border border-white p-4 rounded-xl mb-4">
				<div class="mb-4 relative p-8">
					<label for="name" class="block text-white font-bold mb-2">Name*:</label>
					<input
						type="text"
						name="name"
						id="name"
						placeholder="Name and Sirname"
						class="w-full p-2 border rounded-md"
						bind:value={formData.name}
					/>
				</div>

				<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl">
					{#each formData.other_names as _, index (index)}
						<div class="mb-2">
							<label for="other_names" class="block text-white font-bold mb-2">
								{index === 0 ? "Other Names:" : "Additional Name:"}
							</label>
							<input
								type="text"
								name="other_names"
								id="other_names"
								class="p-2 border rounded-md {index === 0 ? 'w-full' : 'w-11/12'}"
								bind:value={formData.other_names[index]}
								on:input={(e) => handleInputChange(index, e, 1)}
							/>
							{#if index > 0}
								<button type="button" on:click={() => removeInput(index, 1)} class="text-white"> Remove </button>
							{/if}
						</div>
					{/each}
					<button type="button" on:click={() => addInput(1)} class="text-white">Add Name</button>
				</div>

				<div class="mb-4 relative col-span-2 border border-white p-8 rounded-xl">
					{#each formData.code_names as _, index (index)}
						<div class="mb-2">
							<label for="code_names" class="block text-white font-bold mb-2">
								{index === 0 ? "Code Names:" : "Additional Name:"}
							</label>
							<input
								type="text"
								name="code_names"
								id="code_names"
								class="p-2 border rounded-md {index === 0 ? 'w-full' : 'w-11/12'}"
								bind:value={formData.code_names[index]}
								on:input={(e) => handleInputChange(index, e, 2)}
							/>
							{#if index > 0}
								<button type="button" on:click={() => removeInput(index, 2)} class="text-white"> Remove </button>
							{/if}
						</div>
					{/each}
					<button type="button" on:click={() => addInput(2)} class="text-white">Add Name</button>
				</div>
			</div>

			<div id="date-place-info" class="border border-white p-4 rounded-xl mb-4 flex flex-col">
				<div class="border border-white p-8 rounded-xl mb-4">
					<div class="">
						<div class="relative">
							<label for="birth_date" class="block text-white font-bold mb-2">Birth Date:</label>
							<div class="flex flex-row">
								<input
									type="number"
									name="birth_date"
									id="birth_date"
									placeholder="Day"
									min="1"
									max={birthData.maxDay}
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={birthData.day}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="number"
									name="birth_date"
									id="birth_date"
									placeholder="Month"
									min="1"
									max="12"
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={birthData.month}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="number"
									name="birth_date"
									id="birth_date"
									placeholder="Year"
									min="1"
									max="10000"
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={birthData.year}
									on:blur={() => handleBirthDate(1)}
								/>
								<input
									type="date"
									name="birth_date"
									id="birth_date"
									class=" w-9 p-2 border rounded-md"
									bind:value={birthData.date}
									on:input={() => handleBirthDate(2)}
								/>
							</div>
						</div>
					</div>

					<div class="mb-4 relative">
						<label for="birth_place" class="block text-white font-bold mb-2">Birth Place:</label>
						<input
							type="number"
							min="0"
							name="birth_place_id"
							id="birth_place"
							class="w-full p-2 border rounded-md"
							bind:value={formData.birth_place}
						/>
					</div>
				</div>

				<div class="border border-white p-8 rounded-xl">
					<div class="">
						<div class="relative">
							<label for="death_date" class="block text-white font-bold mb-2">Birth Date:</label>
							<div class="flex flex-row">
								<input
									type="number"
									name="death_date"
									id="death_date"
									placeholder="Day"
									min="1"
									max={deathData.maxDay}
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={deathData.day}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="number"
									name="death_date"
									id="death_date"
									placeholder="Month"
									min="1"
									max="12"
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={deathData.month}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="number"
									name="death_date"
									id="death_date"
									placeholder="Year"
									min="1"
									max="10000"
									class="p-2 border rounded-md w-[30%] mr-2 md:mr-4"
									bind:value={deathData.year}
									on:blur={() => handleDeathDate(1)}
								/>
								<input
									type="date"
									name="death_date"
									id="death_date"
									class=" w-9 p-2 border rounded-md"
									bind:value={deathData.date}
									on:input={() => handleDeathDate(2)}
								/>
							</div>
						</div>
					</div>

					<div class="mb-4 relative">
						<label for="death_place" class="block text-white font-bold mb-2">Death Place:</label>
						<input
							type="number"
							min="0"
							name="death_place_id"
							id="death_place"
							class="w-full p-2 border rounded-md"
							bind:value={formData.death_place}
						/>
					</div>
				</div>
			</div>

			<div id="other-info" class="border border-white p-8 px-12 rounded-xl">
				<div class="mb-4 relative">
					<label for="grave" class="block text-white font-bold mb-2">Grave:</label>
					<input type="number" name="grave_id" id="grave" class="w-full p-2 border rounded-md" bind:value={formData.grave} />
				</div>

				<div class="mb-4 relative">
					<label for="inscription" class="block text-white font-bold mb-2">Inscription:</label>
					<input type="text" name="inscription" id="inscription" class="w-full p-2 border rounded-md" bind:value={formData.inscription} />
				</div>

				<div class="col-span-2 mb-4 relative">
					<label for="description" class="block text-white font-bold mb-2">Description:</label>
					<input type="text" name="description" id="description" class="w-full p-2 border rounded-md" bind:value={formData.description} />
				</div>

				<div class="col-span-2 mb-4 relative">
					<label for="sources" class="block text-white font-bold mb-2">Sources:</label>
					<input type="text" name="sources" id="sources" class="w-full p-2 border rounded-md" bind:value={formData.sources} />
				</div>
			</div>
			<div class="flex justify-center items-center mt-4">
				<div>
					<button type="submit" class="active:bg-white active:text-red-600 px-4 py-2 rounded bg-red-600 text-white hover:scale-105 hover:bg-red-500"> <strong>+</strong> <i class="fas fa-user"></i> Add Person</button>
				</div>
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
