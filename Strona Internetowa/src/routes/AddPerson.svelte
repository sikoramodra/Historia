<script>
	let otherNames = [""];
	let codeNames = [""];

	function addInput(i) {
		if (i == 1) {
			otherNames = [...otherNames, ""];
		} else if (i == 2) {
			codeNames = [...codeNames, ""];
		}
	}

	function handleInputChange(index, event, x) {
		if (x == 1) {
			otherNames[index] = event.target.value;
			if (index === otherNames.length - 1 && event.target.value.trim() !== "") {
				addInput(1);
			} else if (event.target.value.trim() === "") {
				for (let i = otherNames.length - 1; i > index; i--) {
					removeInput(i, 1);
				}
			}
		} else if (x == 2) {
			codeNames[index] = event.target.value;
			if (index === codeNames.length - 1 && event.target.value.trim() !== "") {
				addInput(2);
			} else if (event.target.value.trim() === "") {
				for (let i = codeNames.length - 1; i > index; i--) {
					removeInput(i, 2);
				}
			}
		}
	}

	function removeInput(index, i) {
		if (i == 1) {
			otherNames = otherNames.filter((_, i) => i !== index);
		} else if (i == 2) {
			codeNames = codeNames.filter((_, i) => i !== index);
		}
	}
</script>

<!-- <div class="min-h-screen bg-slate-800 flex justify-center items-center">
	<div class="bg-slate-600 h-[80vh] w-[80vw] rounded-2xl shadow-xl border border-slate-400">
		<form action="" class="h-full">
			<input type="text" name="name" id="name" />
			<input type="text" name="other_names" id="other_names" />  add option, so that when input have smth in it, you create new input next to it
			<input type="text" name="inscription" id="inscription" />
			<input type="text" name="code_names" id="code_names" />  add smth here also
			<input type="date" name="birth_date" id="birth_date" />
			<input type="number" name="birth_place" id="birth_place" />
			<input type="date" name="death_date" id="death_date" />
			<input type="number" name="death_place" id="death_place" />
			<input type="number" name="grave" id="grave" />
            <input type="text" name="description" id="description" />
            <input type="text" name="sources" id="sources" />
		</form>
	</div>
</div> -->

<div class="min-h-screen bg-gray-800 flex justify-center items-center">
	<div class="bg-gray-600 h-[80vh] w-[80vw] rounded-2xl shadow-xl border border-gray-400 relative p-2">
		<form action="" method="POST" class="h-full overflow-auto p-6">
			<div id="official-info" class="border border-white p-4 rounded-xl mb-4">
				<div class="mb-4 relative p-4">
					<label for="name" class="block text-white font-bold mb-2">Name:</label>
					<input type="text" name="name" id="name" class="w-full p-2 border rounded-md" />
				</div>

				<!-- <div class="mb-4 relative col-span-2">
					<label for="other_names" class="block text-white font-bold mb-2">Other Names:</label>
					<input type="text" name="other_names" id="other_names" class="w-full p-2 border rounded-md" />
				</div> -->

				<div class="mb-4 relative col-span-2 border border-white p-4 rounded-xl">
					{#each otherNames as value, index (index)}
						<div class="mb-2">
							<label for="other_names" class="block text-white font-bold mb-2">
								{index === 0 ? "Other Names:" : "Additional Name:"}
							</label>
							<input
                                required
								type="text"
								name="other_names"
								id="other_names"
								class="w-full p-2 border rounded-md"
								bind:value
								on:input={(e) => handleInputChange(index, e, 1)}
							/>
							{#if index > 0}
								<button type="button" on:click={() => removeInput(index, 1)} class="text-white"> Remove </button>
							{/if}
						</div>
					{/each}
				</div>

				<div class="mb-4 relative col-span-2 border border-white p-4 rounded-xl">
					{#each codeNames as value, index (index)}
						<div class="mb-2">
							<label for="code_names" class="block text-white font-bold mb-2">
								{index === 0 ? "Code Names:" : "Additional Name:"}
							</label>
							<input
								type="text"
								name="code_names"
								id="code_names"
								class="p-2 border rounded-md {index === 0 ? 'w-full' : 'w-4/5'}"
								bind:value
								on:input={(e) => handleInputChange(index, e, 2)}
							/>
							{#if index > 0}
								<button type="button" on:click={() => removeInput(index, 2)} class="text-white"> Remove </button>
							{/if}
						</div>
					{/each}
				</div>
			</div>

			<div id="date-place-info" class="border border-white p-4 rounded-xl mb-4">
				<div class="mb-4 relative ">
					<label for="birth_date" class="block text-white font-bold mb-2">Birth Date:</label>
					<input type="date" name="birth_date" id="birth_date" class="w-full p-2 border rounded-md" />
				</div>

				<div class="mb-4 relative">
					<label for="birth_place" class="block text-white font-bold mb-2">Birth Place:</label>
					<input type="number" min="0" name="birth_place" id="birth_place" class="w-full p-2 border rounded-md" />
				</div>

				<div class="mb-4 relative">
					<label for="death_date" class="block text-white font-bold mb-2">Death Date:</label>
					<input type="date" name="death_date" id="death_date" class="w-full p-2 border rounded-md" />
				</div>

				<div class="mb-4 relative">
					<label for="death_place" class="block text-white font-bold mb-2">Death Place:</label>
					<input type="number" min="0" name="death_place" id="death_place" class="w-full p-2 border rounded-md" />
				</div>
			</div>

			<div id="other-info" class="border border-white p-4 rounded-xl">
				<div class="mb-4 relative p-4">
					<label for="grave" class="block text-white font-bold mb-2">Grave:</label>
					<input type="number" name="grave" id="grave" class="w-full p-2 border rounded-md" />
				</div>

				<div class="mb-4 relative p-4">
					<label for="inscription" class="block text-white font-bold mb-2">Inscription:</label>
					<input type="text" name="inscription" id="inscription" class="w-full p-2 border rounded-md" />
				</div>

				<div class="col-span-2 mb-4 relative p-4">
					<label for="description" class="block text-white font-bold mb-2">Description:</label>
					<input type="text" name="description" id="description" class="w-full p-2 border rounded-md" />
				</div>

				<div class="col-span-2 mb-4 relative p-4">
					<label for="sources" class="block text-white font-bold mb-2">Sources:</label>
					<input type="text" name="sources" id="sources" class="w-full p-2 border rounded-md" />
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
