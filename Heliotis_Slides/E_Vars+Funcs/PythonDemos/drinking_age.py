
def drinking_age_checker( min_age: int ):
    def may_drink( age: int ):
        return age >= min_age
    return may_drink

new_york = drinking_age_checker( 21 )
québec = drinking_age_checker( 18 )
