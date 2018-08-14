
$(document).ready(function () {
    $("#accordion").accordion({
        header:".item",
        animate: "linear",
        collapsible:true,
        heightStyle: "content",
        icons:false,
        beforeActivate:function (event, ui) {
            var id ={
                id:$(ui.newHeader).attr("id")
            };
            console.log(id);
            $.ajax({
                url:"http://localhost:8081/nutrition",
                data:JSON.stringify(id),
                headers:{
                    Accept : "application/json",
                    "Content-Type":"application/json"
                },
                type:'POST',
                dataType:'json',
                success:function (response) {
                    displayResponse(response,$(ui.newPanel))
                },
                error:function (xhr, textStatus, errorThrown) {
                    console.error('Error! Status = '+ xhr.status);
                    console.error('Text status = '+ textStatus);
                    console.error('Error thrown = '+ errorThrown);
                }

            })
        }
    })

});

function displayResponse(response,element){
    $(element).empty();
    console.log(response);
    var nutrition = response["nutrition"];
    var recipe = response["recipe"];
    $(element)
        .append(
            $("<td>")
                .append(
                    $('<div>',{
                        id:"Nutrition"
                    })
                        .append(
                            $('<h4>',{id:"title"})
                                .text("Nutrition Facts")
                        ).append(
                            $('<div>')
                                .text("Calories "+Math.round(nutrition["calories"]*100)/100+"kcal")
                        ).append(
                            $('<div>')
                                .text("Total Fat "+Math.round(nutrition["total_fat"]*100)/100+"g")
                        ).append(
                            $('<div class="sub">')
                                .text("Saturated Fat "+Math.round(nutrition["saturated_fat"]*100)/100+"g")
                        ).append(
                            $('<div>')
                                .text("Cholesterol "+Math.round(nutrition["cholesterol"]*100)/100+"mg")
                        ).append(
                            $('<div>')
                                .text("Sodium "+Math.round(nutrition["sodium"]*100)/100+"mg")
                        ).append(
                            $('<div>')
                                .text("Potassuim "+Math.round(nutrition["potassium"]*100)/100+"mg")
                        ).append(
                            $('<div>')
                                .text("Total carbohydrates "+Math.round(nutrition["total_carbohydrate"]*100)/100+"g")
                        ).append(
                            $('<div  class="sub">')
                                .text("Dietary fiber "+Math.round(nutrition["dietary_fiber"]*100)/100+"g")
                        ).append(
                            $('<div  class="sub">')
                                .text("Sugars "+Math.round(nutrition["sugars"]*100)/100+"g")
                        ).append(
                            $('<div>')
                                .text("Protein "+Math.round(nutrition["protein"]*100)/100+"g")
                        )
                )
        )
            .append(
                $("<td>")
                    .append(
                        $('<div>',{
                            id:"description"
                        })
                            .text(recipe["directions"])

                    )
        )
            .append(
                $("<td>")
                    .append(
                        $('<div>',{
                            id:"ingredients"
                        })
                    )
        );
    console.log(recipe['ingredients'])
    $.each(recipe['ingredients'],function (i,obj) {
        $('<div>')
            .text(obj['amount']+" "+obj['unit']+" "+obj['name'])
            .appendTo('div#ingredients')
    })

}
