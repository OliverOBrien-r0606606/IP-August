var options;
var optionList;
var index;

$(document).ready(function () {
    $.getJSON("http://localhost:8080/recipe/unit", function (response) {
        options = response;
        optionList = $("<select>");
        $.each(response, function (i, o) {
            var jo = JSON.parse(o);
            optionList.append(
                $("<option>").val(jo["Enum"]).html(jo["option"])
            )

        });
        $('.todropdown').each(function () {
            $(this).append($($(optionList).clone().val($("input", this).val().toUpperCase())));
            $("input", this).remove();
            $(this).removeClass('.todropdown');
        });
        $('.toNumber').each(function () {
            $("input", this).attr('type', 'number').attr('step', 0.1);
            $(this).removeClass('.toNumber');
        })
        $('.move').each(function () {
            var name = $(this).attr('name');
            $(this).appendTo($("."+name));
            $(this).removeClass('.move');
        })
    });
    $('.item-remove-button').each(function () {
        $(this).click(function () {
            removeIngredientLine(this);
        })

    });


    $.getJSON("http://localhost:8080/recipe/allergies/"+$("#id").val(),function (response) {
        for(var allergy in response){
            console.log(allergy);
        }
    })
});


function addIngredientLine() {
    $("<tr>").addClass("list-item")
        .append(
            $("<td>")
                .append(
                    $("<input>")
                        .attr({
                            'type': 'number',
                            'step': 0.1
                        })

                )
                .addClass("amount")
        )
        .append(
            $("<td>")
                .append(
                    $(optionList)
                        .clone()
                        .val(" ")
                )
                .addClass("unit")
        )
        .append(
            $("<td>")
                .append(
                    $("<input>")
                )
                .addClass("name")
        )
        .append(
            $("<td>")
                .append(
                    $('<a>', {
                        'href': '#'
                    })
                        .click(function () {
                            removeIngredientLine(this)
                        })
                        .append(
                            $("<img>", {
                                'src': '/images/remove.gif'
                            })
                                .addClass('alterOption-icon')
                        )
                )
        )
        .insertBefore($("#list-item-new"));


}

function removeIngredientLine(index) {
    $(index).parent().parent().remove();
}

function newRecipe() {

    var name = $("#Name").val();
    var id = $("#id").val();
    var description = $("#description").val();
    var directions = $("#directions").val();
    var vegan = $("#vegan1").val();
    var vegetarian = $("#vegetarian1").val();
    var gluten = $("#gluten1").val();
    var lactose = $("#lactose1").val();
    var nuts = $("#nuts1").val();
    var ingredients = [];
    $(".list-item").each(function () {
        console.log($(".unit select", this).val());
        var ingredient = {

            'amount': $(".amount input", this).val(),
            'unit': $(".unit select", this).val(),
            'name': $(".name input", this).val()
        };
        ingredients.push(ingredient);
    });

    var data = {
        'id': id,
        'name': name,
        'description': description,
        'directions': directions,
        'vegan': vegan,
        'vegetarian': vegetarian,
        'gluten': gluten,
        'lactose': lactose,
        'nuts': nuts,
        'ingredients': ingredients
    };
    console.log(data);

    $.ajax({
        headers:{
            Accept : "application/json",
            "Content-Type":"application/json"
        },
        type:'POST',
        url:"/recipe/post",
        data: JSON.stringify(data),
        dataType:'json',
        success:function (response){
            if(response.redirect){
                window.location.href=response.redirect;
            } else {

            }
        },
        error: function (xhr, textStatus, errorThrown) {
            console.error('Error! Status = '+ xhr.status);
        }


    })
    return false;
}